package cn.wolfcode.accountbook.base.service;


import cn.wolfcode.accountbook.base.domain.LoginInfo;

import java.util.List;


public interface ILoginInfoService {
    /**
     * 通过id获取登录对象
     */
    LoginInfo getById(long id);

    /**
     * 前台用户注册:
     * @param username   :用户名也是手机号
     * @param verifycode :验证码
     * @param password   :密码
     * @param confirmPwd :确认密码
     */
    void register(String username, String verifycode, String password, String confirmPwd);

    /**
     * 判断手机号码是否注册
     * @param phone 手机号码
     * @return
     */
    boolean exisUsername(String phone);

    /**
     * 登录
     */
    void login(LoginInfo loginInfo);


    /**
     * 查询客服(后台人员)
     * @return
     */
    List listByAuditors();
}
   