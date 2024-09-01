package com.chenJ.valet.mgr.service.impl;

import com.chenJ.valet.mgr.service.SysOperLogService;
import com.chenJ.valet.model.entity.system.SysOperLog;
import com.chenJ.valet.model.query.system.SysOperLogQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.system.client.SysOperLogFeignClient;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysOperLogServiceImpl implements SysOperLogService {

    @Resource
    private SysOperLogFeignClient sysOperLogFeignClient;

    @Override
    public PageVo<SysOperLog> findPage(Long page, Long limit, SysOperLogQuery sysOperLogQuery) {
        return sysOperLogFeignClient.findPage(page, limit, sysOperLogQuery).getData();
    }

    @Override
    public void saveSysLog(SysOperLog sysOperLog) {
        sysOperLogFeignClient.saveSysLog(sysOperLog);
    }

    @Override
    public SysOperLog getById(Long id) {
        return sysOperLogFeignClient.getById(id).getData();
    }
}
