package com.chenJ.valet.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenJ.valet.model.entity.system.SysOperLogDo;
import com.chenJ.valet.model.query.system.SysOperLogQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.system.mapper.SysOperLogMapper;
import com.chenJ.valet.system.service.SysOperLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLogDo> implements SysOperLogService {

    @Resource
    private SysOperLogMapper sysOperLogMapper;

    @Override
    public PageVo<SysOperLogDo> findPage(Page<SysOperLogDo> pageParam, SysOperLogQuery sysOperLogQuery) {
        IPage<SysOperLogDo> pageInfo = sysOperLogMapper.selectPage(pageParam, sysOperLogQuery);
        return new PageVo(pageInfo.getRecords(), pageInfo.getPages(), pageInfo.getTotal());
    }

    @Override
    public void saveSysLog(SysOperLogDo sysOperLog) {
        sysOperLogMapper.insert(sysOperLog);
    }
}
