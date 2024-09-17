package com.chenJ.valet.mgr.service.impl;

import com.chenJ.valet.mgr.service.SysMenuService;
import com.chenJ.valet.model.entity.system.SysMenuDo;
import com.chenJ.valet.model.vo.system.AssginMenuVo;
import com.chenJ.valet.system.client.SysMenuFeignClient;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuFeignClient sysMenuFeignClient;

    @Override
    public void save(SysMenuDo sysMenu) {
        sysMenuFeignClient.save(sysMenu);
    }

    @Override
    public void update(SysMenuDo sysMenu) {
        sysMenuFeignClient.update(sysMenu);
    }

    @Override
    public void remove(Long id) {
        sysMenuFeignClient.remove(id);
    }

    @Override
    public List<SysMenuDo> findNodes() {
        return sysMenuFeignClient.findNodes().getData();
    }

    @Override
    public void doAssign(AssginMenuVo assginMenuVo) {
        sysMenuFeignClient.doAssign(assginMenuVo);
    }

    @Override
    public List<SysMenuDo> toAssign(Long roleId) {
        return sysMenuFeignClient.toAssign(roleId).getData();
    }
}
