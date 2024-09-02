package com.chenJ.valet.mgr.service;


import com.chenJ.valet.model.entity.system.SysUserDo;
import com.chenJ.valet.model.query.system.SysUserQuery;
import com.chenJ.valet.model.vo.base.PageVo;

public interface SysUserService {

    SysUserDo getById(Long id);

    void save(SysUserDo sysUser);

    void update(SysUserDo sysUser);

    void remove(Long id);

    PageVo<SysUserDo> findPage(Long page, Long limit, SysUserQuery sysUserQuery);

    void updateStatus(Long id, Integer status);


}
