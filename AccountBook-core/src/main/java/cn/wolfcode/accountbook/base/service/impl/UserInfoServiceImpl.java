package cn.wolfcode.accountbook.base.service.impl;

import cn.wolfcode.accountbook.base.domain.LoginInfo;
import cn.wolfcode.accountbook.base.domain.UserInfo;
import cn.wolfcode.accountbook.base.exception.CustomException;
import cn.wolfcode.accountbook.base.mapper.UserInfoMapper;
import cn.wolfcode.accountbook.base.service.IUserInfoService;
import cn.wolfcode.accountbook.util.AssertUtil;
import cn.wolfcode.accountbook.util.BitStatesUtils;
import cn.wolfcode.accountbook.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public void init(LoginInfo loginInfo) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(loginInfo.getId());
        userInfo.setPhoneNumber(loginInfo.getUsername());
        userInfoMapper.insert(userInfo);
    }

    public UserInfo getById(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }


    public void updateBasicInfo(UserInfo userInfo) {
        //判断参数
        AssertUtil.instance().isNotNull(userInfo,"修改失败");

        //修改基本资料
        UserInfo currentUser = userInfoMapper.selectByPrimaryKey(UserContext.getLoginInfo().getId());
        currentUser.setEducationBackground(userInfo.getEducationBackground());
        currentUser.setHouseCondition(userInfo.getHouseCondition());
        currentUser.setIncomeGrade(userInfo.getIncomeGrade());
        currentUser.setKidCount(userInfo.getKidCount());
        currentUser.setMarriage(userInfo.getMarriage());

        //添加位运算
        if(!currentUser.isBasicInfo()){
            long bitstate = BitStatesUtils.addState(currentUser.getBitstate(), BitStatesUtils.OP_BASIC_INFO);
            currentUser.setBitstate(bitstate);
        }

        update(currentUser);
    }

    public void update(UserInfo user) {
        int count = userInfoMapper.updateByPrimaryKey(user);
        if(count == 0){
            throw new CustomException("用户信息修改失败[乐观锁异常 ID:"+user.getId()+"],请稍后重试");
        }
    }

    public void updateHostingPayPassword(Long uid) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
        if(userInfo != null){
            userInfo.addBitState(BitStatesUtils.OP_HOSTINT_PASSWORD);
            this.update(userInfo);
        }
    }
}
