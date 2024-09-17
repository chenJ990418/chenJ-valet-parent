package com.chenJ.valet.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenJ.valet.model.entity.system.SysRoleDo;
import com.chenJ.valet.model.entity.system.SysUserRoleDo;
import com.chenJ.valet.model.query.system.SysRoleQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.model.vo.system.AssginRoleVo;
import com.chenJ.valet.system.mapper.SysRoleMapper;
import com.chenJ.valet.system.mapper.SysUserRoleMapper;
import com.chenJ.valet.system.service.SysRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleDo> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public PageVo<SysRoleDo> findPage(Page<SysRoleDo> pageParam, SysRoleQuery roleQuery) {
        IPage<SysRoleDo> pageInfo = sysRoleMapper.selectPage(pageParam, roleQuery);
        return new PageVo(pageInfo.getRecords(), pageInfo.getPages(), pageInfo.getTotal());
    }

    @Override
    public Map<String, Object> findRoleByUserId(Long userId) {
        //查询所有的角色
        List<SysRoleDo> allRolesList = this.list();

        //拥有的角色id
        List<SysUserRoleDo> existUserRoleList = sysUserRoleMapper.selectList(new LambdaQueryWrapper<SysUserRoleDo>().eq(SysUserRoleDo::getUserId, userId).select(SysUserRoleDo::getRoleId));
        List<Long> existRoleIdList = existUserRoleList.stream().map(c -> c.getRoleId()).collect(Collectors.toList());

        //对角色进行分类
        List<SysRoleDo> assginRoleList = new ArrayList<>();
        for (SysRoleDo role : allRolesList) {
            //已分配
            if (existRoleIdList.contains(role.getId())) {
                assginRoleList.add(role);
            }
        }

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assginRoleList", assginRoleList);
        roleMap.put("allRolesList", allRolesList);
        return roleMap;
    }

    @Transactional
    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        sysUserRoleMapper.delete(new LambdaQueryWrapper<SysUserRoleDo>().eq(SysUserRoleDo::getUserId, assginRoleVo.getUserId()));

        for (Long roleId : assginRoleVo.getRoleIdList()) {
            if (null == roleId) continue;
            SysUserRoleDo userRole = new SysUserRoleDo();
            userRole.setUserId(assginRoleVo.getUserId());
            userRole.setRoleId(roleId);
            sysUserRoleMapper.insert(userRole);
        }
    }
}
