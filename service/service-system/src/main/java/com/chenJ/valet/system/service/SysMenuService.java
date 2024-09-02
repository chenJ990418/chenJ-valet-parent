package com.chenJ.valet.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.chenJ.valet.model.entity.system.SysMenuDo;
import com.chenJ.valet.model.vo.system.AssginMenuVo;
import com.chenJ.valet.model.vo.system.RouterVo;

import java.util.List;

public interface SysMenuService extends IService<SysMenuDo> {

    /**
     * 菜单树形数据
     *
     * @return
     */
    List<SysMenuDo> findNodes();

    /**
     * 根据角色获取授权权限数据
     *
     * @return
     */
    List<SysMenuDo> findSysMenuByRoleId(Long roleId);

    /**
     * 保存角色权限
     *
     * @param assginMenuVo
     */
    void doAssign(AssginMenuVo assginMenuVo);

    /**
     * 获取用户菜单
     *
     * @param userId
     * @return
     */
    List<RouterVo> findUserMenuList(Long userId);

    /**
     * 获取用户按钮权限
     *
     * @param userId
     * @return
     */
    List<String> findUserPermsList(Long userId);

}
