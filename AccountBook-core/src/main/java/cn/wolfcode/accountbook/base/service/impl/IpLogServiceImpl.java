package cn.wolfcode.accountbook.base.service.impl;

import cn.wolfcode.accountbook.base.domain.IpLog;
import cn.wolfcode.accountbook.base.mapper.IpLogMapper;
import cn.wolfcode.accountbook.base.query.IpLogQuery;
import cn.wolfcode.accountbook.base.query.PageResult;
import cn.wolfcode.accountbook.base.service.IIpLogService;
import cn.wolfcode.accountbook.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class IpLogServiceImpl implements IIpLogService {
    @Autowired
    private IpLogMapper ipLogMapper;

    public void save(String username, int state, int userType) {
        IpLog ipLog = new IpLog();
        ipLog.setUsername(username);
        ipLog.setLoginTime(new Date());
        ipLog.setIp(UserContext.getIpLog());
        ipLog.setState(state);
        ipLog.setUserType(userType);
        ipLogMapper.insert(ipLog);
    }

    public PageResult selectForList(IpLogQuery qo) {
        int count = ipLogMapper.selectForCount(qo);
        if (count == 0){
            return PageResult.empty(qo);
        }
        List<IpLog> list = ipLogMapper.selectForList(qo);
        return new PageResult(list,count,qo.getCurrentPage(),qo.getPageSize());
    }

}
