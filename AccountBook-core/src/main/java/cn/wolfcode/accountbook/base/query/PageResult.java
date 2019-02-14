package cn.wolfcode.accountbook.base.query;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class PageResult {
    private List listData;
    private Integer totalCount;
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPage;
    private Integer prevPage;
    private Integer nextPage;

    public static PageResult empty(Integer pageSize) {
        return new PageResult(Collections.EMPTY_LIST, 0, 1, pageSize);
    }

    public static PageResult empty(Integer pageSize,int currentPage) {
        return new PageResult(Collections.EMPTY_LIST, 0, currentPage, pageSize);
    }


    public static PageResult empty(QueryObject qo) {
        qo.setCurrentPage(1);
        return empty(qo.getPageSize());
    }

    public int getTotalPage() {
        if(totalPage < currentPage){
            return currentPage;
        }
        return totalPage == 0 ? 1 : totalPage;
    }

    public PageResult(List listData, Integer totalCount, Integer currentPage,
                      Integer pageSize) {
        super();
        this.listData = listData;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
                : (totalCount / pageSize) + 1;
        this.prevPage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
        this.nextPage = currentPage + 1 <= totalPage ? currentPage + 1
                : totalPage;
    }
}
