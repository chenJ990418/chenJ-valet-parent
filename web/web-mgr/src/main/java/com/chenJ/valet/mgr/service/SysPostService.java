package com.chenJ.valet.mgr.service;

import com.chenJ.valet.model.entity.system.SysPostDo;
import com.chenJ.valet.model.query.system.SysPostQuery;
import com.chenJ.valet.model.vo.base.PageVo;

import java.util.List;

public interface SysPostService {

    SysPostDo getById(Long id);

    void save(SysPostDo sysPost);

    void update(SysPostDo sysPost);

    void remove(Long id);

    PageVo<SysPostDo> findPage(Long page, Long limit, SysPostQuery sysPostQuery);

    void updateStatus(Long id, Integer status);

    List<SysPostDo> findAll();
}
