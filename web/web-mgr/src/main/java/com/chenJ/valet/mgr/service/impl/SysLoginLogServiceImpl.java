package com.chenJ.valet.mgr.service.impl;

import com.chenJ.valet.mgr.service.SysLoginLogService;
import com.chenJ.valet.model.entity.system.SysLoginLogDo;
import com.chenJ.valet.model.query.system.SysLoginLogQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.system.client.SysLoginLogFeignClient;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Resource
    private SysLoginLogFeignClient sysLoginLogFeignClient;

    @Override
    public PageVo<SysLoginLogDo> findPage(Long page, Long limit, SysLoginLogQuery sysLoginLogQuery) {
        return sysLoginLogFeignClient.findPage(page, limit, sysLoginLogQuery).getData();
    }

    @Override
    public void recordLoginLog(SysLoginLogDo sysLoginLog) {
        sysLoginLogFeignClient.recordLoginLog(sysLoginLog);
    }

    @Override
    public SysLoginLogDo getById(Long id) {
        return sysLoginLogFeignClient.getById(id).getData();
    }
}
