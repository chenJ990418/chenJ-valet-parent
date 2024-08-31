package com.chenJ.valet.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenJ.valet.model.entity.system.SysDept;

import java.util.List;

public interface SysDeptService extends IService<SysDept> {

    List<SysDept> findNodes();

    List<SysDept> findUserNodes();

    void updateStatus(Long id, Integer status);
}
