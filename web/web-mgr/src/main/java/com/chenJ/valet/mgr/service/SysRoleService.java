package com.chenJ.valet.mgr.service;

import com.chenJ.valet.model.entity.system.SysRoleDo;
import com.chenJ.valet.model.query.system.SysRoleQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.model.vo.system.AssginRoleVo;

import java.util.List;
import java.util.Map;

public interface SysRoleService {

    SysRoleDo getById(Long id);

    void save(SysRoleDo sysRole);

    void update(SysRoleDo sysRole);

    void remove(Long id);

    PageVo<SysRoleDo> findPage(Long page, Long limit, SysRoleQuery roleQuery);


    void batchRemove(List<Long> idList);

    Map<String, Object> toAssign(Long userId);

    void doAssign(AssginRoleVo assginRoleVo);

    List<SysRoleDo> findAll();
}
