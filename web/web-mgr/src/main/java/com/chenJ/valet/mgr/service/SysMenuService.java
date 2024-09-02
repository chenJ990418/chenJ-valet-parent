package com.chenJ.valet.mgr.service;


import com.chenJ.valet.model.entity.system.SysMenuDo;
import com.chenJ.valet.model.vo.system.AssginMenuVo;

import java.util.List;

public interface SysMenuService {

    void save(SysMenuDo sysMenu);

    void update(SysMenuDo sysMenu);

    void remove(Long id);

    /**
     * 菜单树形数据
     *
     * @return
     */
    List<SysMenuDo> findNodes();


    /**
     * 保存角色权限
     *
     * @param assginMenuVo
     */
    void doAssign(AssginMenuVo assginMenuVo);


    List<SysMenuDo> toAssign(Long roleId);
}
