package com.chenJ.valet.mgr.service;


import com.chenJ.valet.model.entity.system.SysUser;
import com.chenJ.valet.model.query.system.SysUserQuery;
import com.chenJ.valet.model.vo.base.PageVo;

public interface SysUserService {

    SysUser getById(Long id);

    void save(SysUser sysUser);

    void update(SysUser sysUser);

    void remove(Long id);

    PageVo<SysUser> findPage(Long page, Long limit, SysUserQuery sysUserQuery);

    void updateStatus(Long id, Integer status);


}
