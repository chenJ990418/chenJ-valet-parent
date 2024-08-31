package com.chenJ.valet.mgr.service;

import com.chenJ.valet.model.entity.system.SysLoginLog;
import com.chenJ.valet.model.query.system.SysLoginLogQuery;
import com.chenJ.valet.model.vo.base.PageVo;

public interface SysLoginLogService {

    PageVo<SysLoginLog> findPage(Long page, Long limit, SysLoginLogQuery sysLoginLogQuery);

    /**
     * 记录登录信息
     *
     * @param sysLoginLog
     * @return
     */
    void recordLoginLog(SysLoginLog sysLoginLog);

    SysLoginLog getById(Long id);
}
