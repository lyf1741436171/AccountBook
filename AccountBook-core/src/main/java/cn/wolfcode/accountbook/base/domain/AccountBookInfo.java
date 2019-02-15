package cn.wolfcode.accountbook.base.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class AccountBookInfo {


    private Long id;

    /*
        工人
     */
    private String workName;

    /*
        工作类型
     */
    private String workType;

    /*
        工号
     */
    private String workNumber;

    /*
        时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    /*
        状态
     */
    private Integer state = 1;

    /*
        备注
     */
    private String remark;

    /*
        有效: 1
        无效: 2

     */
    private Integer active = 1;

    public String getJson(){
        Map<String,Object> map =  new HashMap<>();
        map.put("id",id);
        map.put("workName",this.workName);
        map.put("workType",this.workType);
        map.put("workNumber",this.workNumber);
        map.put("workNumber",this.workNumber);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss");
        map.put("date",format.format(date));
        map.put("state",this.state);
        map.put("remark",this.remark);
        return JSON.toJSONString(map);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}