package cn.wolfcode.accountbook.base.mapper;


import cn.wolfcode.accountbook.base.domain.IpLog;
import cn.wolfcode.accountbook.base.query.IpLogQuery;

import java.util.List;

public interface IpLogMapper {

    int insert(IpLog record);

    int selectForCount(IpLogQuery qo);

    List<IpLog> selectForList(IpLogQuery qo);
}