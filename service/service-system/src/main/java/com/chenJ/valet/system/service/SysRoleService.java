package com.chenJ.valet.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenJ.valet.model.entity.system.SysRoleDo;
import com.chenJ.valet.model.query.system.SysRoleQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.model.vo.system.AssginRoleVo;

import java.util.Map;

public interface SysRoleService extends IService<SysRoleDo> {

    PageVo<SysRoleDo> findPage(Page<SysRoleDo> pageParam, SysRoleQuery roleQuery);

    /**
     * 根据用户获取角色数据
     *
     * @param userId
     * @return
     */
    Map<String, Object> findRoleByUserId(Long userId);

    /**
     * 分配角色
     *
     * @param assginRoleVo
     */
    void doAssign(AssginRoleVo assginRoleVo);
}
