package com.chenJ.valet.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenJ.valet.model.entity.system.SysOperLog;
import com.chenJ.valet.model.query.system.SysOperLogQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.system.mapper.SysOperLogMapper;
import com.chenJ.valet.system.service.SysOperLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {

    @Resource
    private SysOperLogMapper sysOperLogMapper;

    @Override
    public PageVo<SysOperLog> findPage(Page<SysOperLog> pageParam, SysOperLogQuery sysOperLogQuery) {
        IPage<SysOperLog> pageInfo = sysOperLogMapper.selectPage(pageParam, sysOperLogQuery);
        return new PageVo(pageInfo.getRecords(), pageInfo.getPages(), pageInfo.getTotal());
    }

    @Override
    public void saveSysLog(SysOperLog sysOperLog) {
        sysOperLogMapper.insert(sysOperLog);
    }
}
