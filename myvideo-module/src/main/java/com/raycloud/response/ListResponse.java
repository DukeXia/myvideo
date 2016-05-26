package com.raycloud.response;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于存取向客户端发送的list
 * Created by linjunjie on 2015/11/28 (linjunjie@raycloud.com).
 */
public class ListResponse {

    private long pageNo;//页码

    private long pageSize;//每页显示条数

    private long total;//总页数

    private List items = new ArrayList();//存放list集合

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
