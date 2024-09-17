package com.chenJ.valet.mgr.service;

import com.chenJ.valet.model.entity.system.SysLoginLogDo;
import com.chenJ.valet.model.query.system.SysLoginLogQuery;
import com.chenJ.valet.model.vo.base.PageVo;

public interface SysLoginLogService {

    PageVo<SysLoginLogDo> findPage(Long page, Long limit, SysLoginLogQuery sysLoginLogQuery);

    /**
     * 记录登录信息
     *
     * @param sysLoginLog
     * @return
     */
    void recordLoginLog(SysLoginLogDo sysLoginLog);

    SysLoginLogDo getById(Long id);
}
