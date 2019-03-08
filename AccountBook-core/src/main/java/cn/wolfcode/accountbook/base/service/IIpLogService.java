package cn.wolfcode.accountbook.base.service;


import cn.wolfcode.accountbook.base.query.IpLogQuery;
import cn.wolfcode.accountbook.base.query.PageResult;

public interface IIpLogService {

    /**
     * 保存登录日志
     */
    void save(String username, int state, int userType);

    /**
     *分页查询
     */
    PageResult selectForList(IpLogQuery qo);
}
