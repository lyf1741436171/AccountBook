package cn.wolfcode.accountbook.base.service;


import cn.wolfcode.accountbook.base.domain.LoginInfo;
import cn.wolfcode.accountbook.base.domain.UserInfo;

public interface IUserInfoService {
    /**
     * 初始化UserInfo
     */
    void init(LoginInfo loginInfo);

    /**
     * 根据Id查询数据
     * @param id
     * @return
     */
    UserInfo getById(Long id);

    /**
     * 更改用户个人资料
     * @param userInfo
     */
    void updateBasicInfo(UserInfo userInfo);

    /*
        乐观锁
     */
    void update(UserInfo user);

    /**
     * 修改用户的位状态,设置托管支付密码设置状态
     * @param uid
     */
    void updateHostingPayPassword(Long uid);
}
