package com.raycloud.pojo.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie on 2015/11/28 (linjunjie@raycloud.com).
 */
public class BasePojo implements Serializable {


    private static final long serialVersionUID = 1884030458402249285L;
    /**
     * 分表的序号，比如 invoice_0,invoice_1 ,就是最后面那个数字
     */
    private Integer splitTableName;

    private String splitDBName;

    /**
     * limit startRow,endRow;
     */
    private Integer startRow;
    private Integer pageNo;
    private Integer pageSize;
    /**
     * 自定义字段
     */
    protected String fields;

    /**====================批量查询时id设置**/
    protected List<Long> keys;
    /**====================结束**/

    /**====================批量查询时order条件设置**/
    protected List<OrderField> orderFields = new ArrayList<OrderField>();

    public class OrderField{
        private String fieldName;
        private String order;
        public OrderField(String fieldName,String order){
            this.fieldName = fieldName;
            this.order = order;
        }
    }
    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**====================结束**/

    public Integer getSplitTableName() {
        return splitTableName;
    }

    public void setSplitTableName(Integer splitTableName) {
        this.splitTableName = splitTableName;
    }

    public String getSplitDBName() {
        return splitDBName;
    }

    public void setSplitDBName(String splitDBName) {
        this.splitDBName = splitDBName;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
