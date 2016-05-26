package com.raycloud.service.impl;

import com.raycloud.constant.ResponseResultConstant;
import com.raycloud.constant.WebContextConstant;
import com.raycloud.dao.*;
import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.*;
import com.raycloud.request.*;
import com.raycloud.response.ViewBoardList;
import com.raycloud.response.ViewCategoryList;
import com.raycloud.response.ViewContentDetail;
import com.raycloud.response.ViewContentList;
import com.raycloud.service.BaseService;
import com.raycloud.util.ContentTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
@Service
public class PublicBlogService extends BaseService implements com.raycloud.service.PublicBlogService{

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private BoardDao boardDao;

    @Autowired
    private SubBoardDao subBoardDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private UserCategoryRelationDao userCategoryRelationDao;

    /**
     * 获得文章列表
     * @param request
     * @return
     * @throws ServiceException
     */
    public ViewContentList getContentList(ArticleListGetRequest request)throws ServiceException{
        ViewContentList viewContentList = new ViewContentList();
        String username = null;
        try {
            username = URLDecoder.decode(request.getUsername(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = getUser(username);
        if(user == null){
            throw new ServiceException("用户不存在", ResponseResultConstant.USER_NOT_EXISTS);
        }

        Article article = new Article();
        article.setSplitTableName(user.getDbConfig().getArticleDbId());
        //设置查找条件
        article.setUsername(request.getUsername());
        article.setCategoryId(request.getCategoryId());
        article.setStartRow((request.getPageNo() - 1) * request.getPageSize());
        article.setPageSize(request.getPageSize());
        article.orderByCreated(true);
        //查找文章的总数量
        viewContentList.setTotal(articleDao.getCount(article));
        //查找文章列表
        viewContentList.toContentListResponse(articleDao.getList(article));
        return viewContentList;
    }

    /**
     * 获得文章详细内容
     * @return
     */
    public ViewContentDetail getContentDetail(ArticleDetailGetRequest request)throws ServiceException{
        ViewContentDetail viewContentDetail = new ViewContentDetail();
        User user = getUser(request.getUsername());
        Article article = new Article();
        article.setSplitTableName(user.getDbConfig().getArticleDbId());
        article.setId(request.getId());
        //获取文章详细内容
        viewContentDetail.toContentDetailResponse(articleDao.get(article), article.getSplitTableName());
        article.setReadNum(1L);
        articleDao.updateNum(article);
        return viewContentDetail;
    }

    /**
     * 插入一篇文章
     * @param request
     * @throws ServiceException
     */
    public void insertArticle(ArticleInsertRequest request,User user)throws ServiceException{
        //图片处理
        int index = request.getCoverImage().getOriginalFilename().indexOf(".");
        String fileName = null;
        fileName = (index == -1? request.getCoverImage().getOriginalFilename():request.getCoverImage().getOriginalFilename().substring(0,index));
        String savePath = null;
        synchronized(user.getUsername().intern()) {
            savePath = new StringBuilder("/resources/upload/").append(fileName).append(System.currentTimeMillis()).append(ContentTypeUtil.getExtension(request.getCoverImage().getContentType())).toString();
        }
        try {
            request.getCoverImage().transferTo(new File(WebContextConstant.webRealPath+savePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //图片处理结束
        Article article = new Article();
        article.setSplitTableName(user.getDbConfig().getArticleDbId());
        article.setAuthor(request.getAuthor());
        article.setUsername(user.getUsername());
        article.setContent(request.getContent());
        article.setHeadPhotoUrl(savePath);
        article.setBoardNum(0);
        article.setCategoryId(request.getCategoryId());
        article.setReadNum(0L);
        article.setTitle(request.getTitle());
        article.setStatus(1);
        article.setCreated(new Date());
        articleDao.insert(article);
        UserCategoryRelation userCategoryRelation = new UserCategoryRelation();
        userCategoryRelation.setSplitTableName(user.getDbConfig().getUserCategoryRelationDbId());
        userCategoryRelation.setUsername(user.getUsername());
        userCategoryRelation.setCategoryId(request.getCategoryId());
        userCategoryRelation.setArticleNum(1);
        userCategoryRelationDao.updateArticleNum(userCategoryRelation);

    }

    /**
     * 获得留言板列表
     * @param request
     * @return
     */
    public ViewBoardList getBoardList(BoardListGetRequest request)throws ServiceException{
        ViewBoardList viewBoardList = new ViewBoardList();
        User user = getUser(request.getUsername());
        Board board = new Board();
        board.setSplitTableName(request.getSplit());//分表
        board.setArticleId(request.getArticleId());
        board.setStartRow((request.getPageNo() - 1) * request.getPageSize());
        board.setPageSize(request.getPageSize());
        board.orderByCreated(true);
        SubBoard subBoard = new SubBoard();
        subBoard.setSplitTableName(request.getSplit());
        subBoard.setArticleId(request.getArticleId());
        List<SubBoard> subBoardList = subBoardDao.getList(subBoard);
        viewBoardList.toViewBoardListResponse(boardDao.getList(board),subBoardDao.getList(subBoard));
        viewBoardList.setTotal(boardDao.getCount(board));

        return viewBoardList;
    }

    /**
     * 留言回复
     * @param request
     */
    public void boardReply(BoardAddRequest request,User user)throws ServiceException{
        //留言的用户必须是登陆的.
        Article article = new Article();
        article.setId(request.getArticleId());
        article.setSplitTableName(request.getSplit());
        article.setBoardNum(1);
        article.setReadNum(1L);
        articleDao.updateNum(article);
        if(request.getBoardId() != null){
            //子留言
            SubBoard subBoard = new SubBoard();
            subBoard.setSplitTableName(request.getSplit());
            subBoard.setUsername(user.getUsername());
            subBoard.setArticleId(request.getArticleId());
            subBoard.setHeadPhotoUrl(user.getHeadPhotoUrl());
            subBoard.setContent(request.getContent());
            subBoard.setBoardId(request.getBoardId());
            subBoard.setCreated(new Date());
            subBoard.setStatus(1);
            subBoardDao.insert(subBoard);
        }else{
            //主留言
            Board board = new Board();
            board.setSplitTableName(request.getSplit());
            board.setArticleId(request.getArticleId());
            board.setHeadPhotoUrl(user.getHeadPhotoUrl());
            board.setUsername(user.getUsername());
            board.setContent(request.getContent());
            board.setCreated(new Date());
            board.setStatus(1);
            boardDao.insert(board);
        }
    }

    /**
     * 添加分类
     * @param request
     * @param user
     */
    public void addCategory(CategoryAddRequest request,User user)throws ServiceException{
        Category category = new Category();
        category.setName(request.getName());
        Category use = categoryDao.get(category);
        if(use == null){
            //不存在
            category.setStatus(1);
            category.setCreated(new Date());
            categoryDao.insert(category);
        }else{
            //存在
            category.setId(use.getId());
        }
        UserCategoryRelation userCategoryRelation = new UserCategoryRelation();
        userCategoryRelation.setSplitTableName(user.getDbConfig().getUserCategoryRelationDbId());
        userCategoryRelation.setCategoryId(category.getId());
        userCategoryRelation.setUsername(user.getUsername());
        userCategoryRelation.setArticleNum(0);
        if(userCategoryRelationDao.get(userCategoryRelation) != null){
            throw new ServiceException("请勿重复添加!",ResponseResultConstant.ALREADY_EXISTS_ERROR);
        }else {
            userCategoryRelationDao.insert(userCategoryRelation);
        }
    }

    /**
     * 获取分类列表
     * @param request
     * @return
     */
    public ViewCategoryList getCategoryList(CategoryListGetRequest request)throws ServiceException{
        User user = new User();
        user.setUsername(request.getUsername());
        user = userDao.get(user);
        UserCategoryRelation userCategoryRelation = new UserCategoryRelation();
        userCategoryRelation.setUsername(user.getUsername());
        userCategoryRelation.setSplitTableName(user.getDbConfig().getUserCategoryRelationDbId());
        ViewCategoryList viewCategoryList = new ViewCategoryList();
        viewCategoryList.toCategoryResponse(userCategoryRelationDao.getList(userCategoryRelation));
        viewCategoryList.setTotal( userCategoryRelationDao.getCount(userCategoryRelation));
        return viewCategoryList;
    }


    public void executeWOW(){
        System.out.println("这不是在调用我吗!?");
    }


}
