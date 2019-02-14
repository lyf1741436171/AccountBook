package cn.wolfcode.accountbook.base.query;

import cn.wolfcode.accountbook.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.util.Date;

public class AccountBookQuery extends QueryObject{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date endDate;

    private Integer state;

    private  String username;



    public String getUsername() {
        return StringUtils.hasLength(username)? username : null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return DateUtil.getEndDate(endDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
