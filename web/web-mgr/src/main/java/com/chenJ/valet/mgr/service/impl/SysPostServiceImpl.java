package com.chenJ.valet.mgr.service.impl;

import com.chenJ.valet.mgr.service.SysPostService;
import com.chenJ.valet.model.entity.system.SysPostDo;
import com.chenJ.valet.model.query.system.SysPostQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.system.client.SysPostFeignClient;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysPostServiceImpl implements SysPostService {

    @Resource
    private SysPostFeignClient sysPostFeignClient;

    @Override
    public SysPostDo getById(Long id) {
        return sysPostFeignClient.getById(id).getData();
    }

    @Override
    public void save(SysPostDo sysPost) {
        sysPostFeignClient.save(sysPost);
    }

    @Override
    public void update(SysPostDo sysPost) {
        sysPostFeignClient.update(sysPost);
    }

    @Override
    public void remove(Long id) {
        sysPostFeignClient.remove(id);
    }

    @Override
    public PageVo<SysPostDo> findPage(Long page, Long limit, SysPostQuery sysPostQuery) {
        return sysPostFeignClient.findPage(page, limit, sysPostQuery).getData();
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        sysPostFeignClient.updateStatus(id, status);
    }

    @Override
    public List<SysPostDo> findAll() {
        return sysPostFeignClient.findAll().getData();
    }
}
