package com.chenJ.valet.mgr.service.impl;

import com.chenJ.valet.mgr.service.SysMenuService;
import com.chenJ.valet.model.entity.system.SysMenu;
import com.chenJ.valet.model.vo.system.AssginMenuVo;
import com.chenJ.valet.system.client.SysMenuFeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuFeignClient sysMenuFeignClient;

    @Override
    public void save(SysMenu sysMenu) {
        sysMenuFeignClient.save(sysMenu);
    }

    @Override
    public void update(SysMenu sysMenu) {
        sysMenuFeignClient.update(sysMenu);
    }

    @Override
    public void remove(Long id) {
        sysMenuFeignClient.remove(id);
    }

    @Override
    public List<SysMenu> findNodes() {
        return sysMenuFeignClient.findNodes().getData();
    }

    @Override
    public void doAssign(AssginMenuVo assginMenuVo) {
        sysMenuFeignClient.doAssign(assginMenuVo);
    }

    @Override
    public List<SysMenu> toAssign(Long roleId) {
        return sysMenuFeignClient.toAssign(roleId).getData();
    }
}
