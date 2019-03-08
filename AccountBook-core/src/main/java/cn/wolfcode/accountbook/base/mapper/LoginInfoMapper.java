package cn.wolfcode.accountbook.base.mapper;


import cn.wolfcode.accountbook.base.domain.LoginInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginInfoMapper {

    int insert(LoginInfo record);

    LoginInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(LoginInfo record);

    int exisUsername(String phone);

    LoginInfo login(@Param("username") String username, @Param("password") String password);

    List<LoginInfo> selectByAuditors();
}