package com.chenJ.valet.mgr.service.impl;

import com.chenJ.valet.mgr.service.SysDeptService;
import com.chenJ.valet.model.entity.system.SysDeptDo;
import com.chenJ.valet.system.client.SysDeptFeignClient;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysDeptServiceImpl implements SysDeptService {

    @Resource
    private SysDeptFeignClient sysDeptFeignClient;


    @Override
    public List<SysDeptDo> findNodes() {
        return sysDeptFeignClient.findNodes().getData();
    }

    @Override
    public List<SysDeptDo> findUserNodes() {
        return sysDeptFeignClient.findUserNodes().getData();
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        sysDeptFeignClient.updateStatus(id, status);
    }

    @Override
    public SysDeptDo getById(Long id) {
        return sysDeptFeignClient.getById(id).getData();
    }

    @Override
    public void save(SysDeptDo sysDept) {
        sysDeptFeignClient.save(sysDept);
    }

    @Override
    public void update(SysDeptDo sysDept) {
        sysDeptFeignClient.update(sysDept);
    }

    @Override
    public void remove(Long id) {
        sysDeptFeignClient.remove(id);
    }
}

