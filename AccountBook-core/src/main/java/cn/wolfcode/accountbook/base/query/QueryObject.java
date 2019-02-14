package cn.wolfcode.accountbook.base.query;

import lombok.Getter;
import lombok.Setter;


public class QueryObject {
    private int pageSize = 10;
    private int currentPage = 1;
    //排序的列
    private String orderBy;
    //排序的类型
    private String orderType;

    public int getStart(){
        return (currentPage - 1)*pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
