package com.chenJ.valet.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenJ.valet.model.entity.system.SysPostDo;
import com.chenJ.valet.model.query.system.SysPostQuery;
import com.chenJ.valet.model.vo.base.PageVo;

import java.util.List;

public interface SysPostService extends IService<SysPostDo> {

    PageVo<SysPostDo> findPage(Page<SysPostDo> pageParam, SysPostQuery sysPostQuery);

    void updateStatus(Long id, Integer status);

    List<SysPostDo> findAll();
}
