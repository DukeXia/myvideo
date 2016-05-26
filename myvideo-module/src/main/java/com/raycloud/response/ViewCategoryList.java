package com.raycloud.response;

import com.raycloud.pojo.Category;
import com.raycloud.pojo.UserCategoryRelation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
public class ViewCategoryList {

    private Integer total;

    private List<CategoryBean> categoryBeanList = new ArrayList<CategoryBean>();



    public class CategoryBean{

        private Long id;

        private String name;

        private Integer articleNum;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getArticleNum() {
            return articleNum;
        }

        public void setArticleNum(Integer articleNum) {
            this.articleNum = articleNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public void toCategoryResponse(List<UserCategoryRelation> userCategoryRelationList){

        CategoryBean categoryBean = null;
        for(UserCategoryRelation u : userCategoryRelationList){
            categoryBean = new CategoryBean();
            categoryBean.setName(u.getName());
            categoryBean.setArticleNum(u.getArticleNum());
            categoryBean.setId(u.getId());
            categoryBeanList.add(categoryBean);
        }

    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<CategoryBean> getCategoryBeanList() {
        return categoryBeanList;
    }

    public void setCategoryBeanList(List<CategoryBean> categoryBeanList) {
        this.categoryBeanList = categoryBeanList;
    }
}
