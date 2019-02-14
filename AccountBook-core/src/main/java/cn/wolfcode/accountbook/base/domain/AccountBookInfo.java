package cn.wolfcode.accountbook.base.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
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


}