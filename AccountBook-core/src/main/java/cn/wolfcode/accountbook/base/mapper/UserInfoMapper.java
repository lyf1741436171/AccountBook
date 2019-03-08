package cn.wolfcode.accountbook.base.mapper;


import cn.wolfcode.accountbook.base.domain.UserInfo;

public interface UserInfoMapper {

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(UserInfo record);
}