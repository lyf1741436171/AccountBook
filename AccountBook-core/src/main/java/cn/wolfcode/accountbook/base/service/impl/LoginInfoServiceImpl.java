package cn.wolfcode.accountbook.base.service.impl;


import cn.wolfcode.accountbook.base.domain.LoginInfo;
import cn.wolfcode.accountbook.base.mapper.LoginInfoMapper;
import cn.wolfcode.accountbook.base.service.ILoginInfoService;
import cn.wolfcode.accountbook.base.service.IUserInfoService;
import cn.wolfcode.accountbook.base.vo.VerifyCodeVO;
import cn.wolfcode.accountbook.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LoginInfoServiceImpl implements ILoginInfoService {

    @Autowired
    private LoginInfoMapper loginInfoMapper ;

    @Autowired
    private IUserInfoService userInfoService ;

    @Override
    public LoginInfo getById(long id) {
        return loginInfoMapper.selectByPrimaryKey(id) ;
    }

    @Override
    public void register(String username, String verifycode, String password, String confirmPwd) {

        AssertUtil.instance().isMobile(username,"手机号格式不正确")
                .isNotNull(password,"密码不能为空")
                .isLength(password.length(), Constants.MIN_LENGTH_PASSWORD,Constants.MAX_LENGTH_PASSWORD,
                        "密码长度必须是"+Constants.MIN_LENGTH_PASSWORD+"-"+Constants.MAX_LENGTH_PASSWORD+"为数")
                .isEquals(password,confirmPwd,"两次密码输入的不一致")
                .isLength(verifycode.length(),Constants.LENGTH_VERIFYCODE,"验证码格式无效")
                .isFalse(exisUsername(username),"手机号已被注册");

        //获取发送验证码的手机号
        VerifyCodeVO verifyCodeVO = UserContext.getVerifyCodeVO();
        AssertUtil.instance().isNotNull(verifyCodeVO,"请从新发送验证码")
                //注册的手机号和发送验证码的手机号不一致
                .isEquals(verifyCodeVO.getPhone(),username,"注册的手机号和发送验证码的手机号不一致")
                //验证码过期校验
                .isEquals(verifyCodeVO.getCode(),verifycode,"无效的验证码")
                //判断验证码是否过期
                .isFalse(DateUtil.getSecondsBetween(new Date(),verifyCodeVO.getSendTime()) > Constants.VERIFYCODE_VALID_SECOND,
                        "验证已失效,请重新发送");

        //校验
        LoginInfo loginInfo = new LoginInfo() ;
        loginInfo.setUsername(username);
        loginInfo.setPassword(MD5.encode(password+username) );
        loginInfoMapper.insert(loginInfo) ;

        //初始化账户
        userInfoService.init(loginInfo);

        //初始化Account
        //accountService.init(loginInfo);
        //同步一个托管平台的账户
        //hostingService.createAccount(loginInfo);
        //绑定手机号
       // hostingService.bindPhone(loginInfo);

    }


    //判断手机号码是否注册
    public boolean exisUsername(String phone) {
        boolean exisUsername = loginInfoMapper.exisUsername(phone) > 0;
        return exisUsername;
    }
    //登录
    public void login(LoginInfo loginInfo) {
        AssertUtil.instance().isNotNull(loginInfo,"用户异常");
        if(loginInfo.getUserType() == LoginInfo.USERTYPE_WEBSITE ){
            //1,基本参数判断
            AssertUtil.instance().isMobile(loginInfo.getUsername(),"用户名格式错误").
                    isLength(loginInfo.getPassword().length(),Constants.MIN_LENGTH_PASSWORD,Constants.MAX_LENGTH_PASSWORD,"密码格式错误");

        }
        //2.执行登录
        String password = MD5.encode(loginInfo.getPassword() + loginInfo.getUsername());
        System.out.println("密码："+password);
        LoginInfo info = loginInfoMapper.login(loginInfo.getUsername(),password);

        //3.判断登录是否成功
        AssertUtil.instance()
                .isNotNull(info,"用户名或密码错误")
                .isFalse(info.getState() != LoginInfo.STATE_NORMAL,"用户已被锁定,请联系客服")
                .isFalse(loginInfo.getUserType() != info.getUserType(),"用户登录异常");


        //4.若登录成功则保存到session中
        UserContext.setLoginInfo(info);
    }

    public List listByAuditors() {
        return loginInfoMapper.selectByAuditors();
    }


}
