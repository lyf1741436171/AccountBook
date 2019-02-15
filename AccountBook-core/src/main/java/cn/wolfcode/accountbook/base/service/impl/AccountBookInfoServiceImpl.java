package cn.wolfcode.accountbook.base.service.impl;

import cn.wolfcode.accountbook.base.domain.AccountBookInfo;
import cn.wolfcode.accountbook.base.mapper.AccountBookInfoMapper;
import cn.wolfcode.accountbook.base.query.AccountBookQuery;
import cn.wolfcode.accountbook.base.query.PageResult;
import cn.wolfcode.accountbook.base.service.IAccountBookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountBookInfoServiceImpl implements IAccountBookInfoService {

    @Autowired
    private AccountBookInfoMapper accountBookInfoMapper;


    public PageResult selectForList(AccountBookQuery qo) {
        int count = accountBookInfoMapper.selectForCount(qo);
        if (count == 0){
            return PageResult.empty(qo);
        }
        List<AccountBookInfo> list = accountBookInfoMapper.selectForList(qo);
        return new PageResult(list,count,qo.getCurrentPage(),qo.getPageSize());
    }

    @Override
    public void saveOrUpdate(AccountBookInfo accountBookInfo) {

        if (accountBookInfo.getId() == null){
            accountBookInfoMapper.insert(accountBookInfo);
        }else{
            accountBookInfoMapper.updateByPrimaryKey(accountBookInfo);
        }
    }
    @Override
    public void deleteUser(Long id){
        accountBookInfoMapper.deleteByPrimaryKey(id);
    }
}
