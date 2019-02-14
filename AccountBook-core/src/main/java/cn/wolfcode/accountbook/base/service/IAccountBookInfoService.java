package cn.wolfcode.accountbook.base.service;

import cn.wolfcode.accountbook.base.domain.AccountBookInfo;
import cn.wolfcode.accountbook.base.query.AccountBookQuery;
import cn.wolfcode.accountbook.base.query.PageResult;

public interface IAccountBookInfoService {
    PageResult selectForList(AccountBookQuery qo);

    void saveOrUpdate(AccountBookInfo accountBookInfo);
}
