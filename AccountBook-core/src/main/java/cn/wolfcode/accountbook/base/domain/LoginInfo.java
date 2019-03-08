package cn.wolfcode.accountbook.base.domain;

/**
 * 用户登录模型
 */
public class LoginInfo extends BaseDomain {

    /**
     * 登录状态:正常
     */
    public static final int STATE_NORMAL = 0;
    /**
     * 登录状态:锁定
     */
    public static final int STATE_LOCK = 1;

    /**
     * 用户类型 :前台用户
     */

    public static final int USERTYPE_WEBSITE = 0;

    /**
     * 后台用户
     */
    public static final int USERTYPE_MGRSITE = 1;


    /*
        用户名
     */
    private String username;

    /*
        密码
    */
    private String password;

    /*
        状态: 0正常/1锁定
    */
    private Integer state = STATE_NORMAL;


    /*
        用户类别:0前端/1后端
     */
    private Integer userType = USERTYPE_WEBSITE;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
