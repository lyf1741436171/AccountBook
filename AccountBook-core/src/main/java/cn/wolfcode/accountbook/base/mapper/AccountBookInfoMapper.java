package cn.wolfcode.accountbook.base.mapper;

import cn.wolfcode.accountbook.base.domain.AccountBookInfo;
import cn.wolfcode.accountbook.base.query.AccountBookQuery;

import java.util.List;

public interface AccountBookInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountBookInfo record);

    AccountBookInfo selectByPrimaryKey(Long id);

    List<AccountBookInfo> selectAll();

    int updateByPrimaryKey(AccountBookInfo record);

    int selectForCount(AccountBookQuery qo);

    List<AccountBookInfo> selectForList(AccountBookQuery qo);
}