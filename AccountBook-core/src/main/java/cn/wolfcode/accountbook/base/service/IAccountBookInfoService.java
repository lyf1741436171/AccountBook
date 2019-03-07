package cn.wolfcode.accountbook.base.service;

import cn.wolfcode.accountbook.base.domain.AccountBookInfo;
import cn.wolfcode.accountbook.base.query.AccountBookQuery;
import cn.wolfcode.accountbook.base.query.PageResult;

import java.util.List;

public interface IAccountBookInfoService {
    PageResult selectForList(AccountBookQuery qo);

    void saveOrUpdate(AccountBookInfo accountBookInfo);

    void deleteUser(Long id);

    List<AccountBookInfo> selectAll();
}
