package com.chenJ.valet.system.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenJ.valet.model.entity.system.SysUserDo;
import com.chenJ.valet.model.query.system.SysUserQuery;
import com.chenJ.valet.model.vo.base.PageVo;

import java.util.Map;

public interface SysUserService extends IService<SysUserDo> {

    PageVo<SysUserDo> findPage(Page<SysUserDo> pageParam, SysUserQuery adminQuery);

    void updateStatus(Long id, Integer status);

    SysUserDo getByUsername(String username);

    /**
     * 根据用户名获取用户登录信息
     *
     * @param userId
     * @return
     */
    Map<String, Object> getUserInfo(Long userId);
}
