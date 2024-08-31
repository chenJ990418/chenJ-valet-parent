package com.chenJ.valet.mgr.service;

import com.chenJ.valet.model.entity.system.SysOperLog;
import com.chenJ.valet.model.query.system.SysOperLogQuery;
import com.chenJ.valet.model.vo.base.PageVo;

public interface SysOperLogService {

    PageVo<SysOperLog> findPage(Long page, Long limit, SysOperLogQuery sysOperLogQuery);

    /**
     * 保存系统日志记录
     */
    void saveSysLog(SysOperLog sysOperLog);

    SysOperLog getById(Long id);
}
