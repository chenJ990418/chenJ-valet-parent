package com.chenJ.valet.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenJ.valet.model.entity.system.SysLoginLogDo;
import com.chenJ.valet.model.query.system.SysLoginLogQuery;
import com.chenJ.valet.model.vo.base.PageVo;

public interface SysLoginLogService extends IService<SysLoginLogDo> {

    PageVo<SysLoginLogDo> findPage(Page<SysLoginLogDo> pageParam, SysLoginLogQuery sysLoginLogQuery);

    /**
     * 记录登录信息
     *
     * @param sysLoginLog
     * @return
     */
    void recordLoginLog(SysLoginLogDo sysLoginLog);

}
