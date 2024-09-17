package com.chenJ.valet.mgr.service;

import com.chenJ.valet.model.entity.system.SysDeptDo;

import java.util.List;

public interface SysDeptService {

    List<SysDeptDo> findNodes();

    List<SysDeptDo> findUserNodes();

    void updateStatus(Long id, Integer status);

    SysDeptDo getById(Long id);

    void save(SysDeptDo sysDept);

    void update(SysDeptDo sysDept);

    void remove(Long id);
}
