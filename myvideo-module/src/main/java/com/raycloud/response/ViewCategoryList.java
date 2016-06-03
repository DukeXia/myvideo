package com.raycloud.response;

import com.raycloud.pojo.Category;

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

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public void toCategoryResponse(List<Category> categoryList){
        CategoryBean categoryBean = null;
        for(Category c : categoryList){
            categoryBean = new CategoryBean();
            categoryBean.setId(c.getId());
            categoryBean.setName(c.getName());
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
