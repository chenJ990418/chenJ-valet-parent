package com.chenJ.valet.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenJ.valet.model.entity.system.SysDeptDo;

import java.util.List;

public interface SysDeptService extends IService<SysDeptDo> {

    List<SysDeptDo> findNodes();

    List<SysDeptDo> findUserNodes();

    void updateStatus(Long id, Integer status);
}
