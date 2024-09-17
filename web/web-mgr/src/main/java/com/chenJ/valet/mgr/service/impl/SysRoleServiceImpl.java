package com.chenJ.valet.mgr.service.impl;

import com.chenJ.valet.mgr.service.SysRoleService;
import com.chenJ.valet.model.entity.system.SysRoleDo;
import com.chenJ.valet.model.query.system.SysRoleQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.model.vo.system.AssginRoleVo;
import com.chenJ.valet.system.client.SysRoleFeignClient;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleFeignClient sysRoleFeignClient;

    @Override
    public SysRoleDo getById(Long id) {
        return sysRoleFeignClient.getById(id).getData();
    }

    @Override
    public void save(SysRoleDo sysRole) {
        sysRoleFeignClient.save(sysRole);
    }

    @Override
    public void update(SysRoleDo sysRole) {
        sysRoleFeignClient.update(sysRole);
    }

    @Override
    public void remove(Long id) {
        sysRoleFeignClient.remove(id);
    }

    @Override
    public PageVo<SysRoleDo> findPage(Long page, Long limit, SysRoleQuery roleQuery) {
        return sysRoleFeignClient.findPage(page, limit, roleQuery).getData();
    }

    @Override
    public void batchRemove(List<Long> idList) {
        sysRoleFeignClient.batchRemove(idList);
    }

    @Override
    public Map<String, Object> toAssign(Long userId) {
        return sysRoleFeignClient.toAssign(userId).getData();
    }

    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        sysRoleFeignClient.doAssign(assginRoleVo);
    }

    @Override
    public List<SysRoleDo> findAll() {
        return sysRoleFeignClient.findAll().getData();
    }
}
