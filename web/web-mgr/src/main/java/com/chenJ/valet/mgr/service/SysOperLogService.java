package com.chenJ.valet.mgr.service;

import com.chenJ.valet.model.entity.system.SysOperLogDo;
import com.chenJ.valet.model.query.system.SysOperLogQuery;
import com.chenJ.valet.model.vo.base.PageVo;

public interface SysOperLogService {

    PageVo<SysOperLogDo> findPage(Long page, Long limit, SysOperLogQuery sysOperLogQuery);

    /**
     * 保存系统日志记录
     */
    void saveSysLog(SysOperLogDo sysOperLog);

    SysOperLogDo getById(Long id);
}
