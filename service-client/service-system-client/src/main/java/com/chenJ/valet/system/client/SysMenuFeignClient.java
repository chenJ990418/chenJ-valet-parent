package com.chenJ.valet.system.client;

import com.chenJ.valet.common.result.Result;
import com.chenJ.valet.model.entity.system.SysMenuDo;
import com.chenJ.valet.model.vo.system.AssginMenuVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "service-system")
public interface SysMenuFeignClient {


    /**
     * 获取菜单
     *
     * @return
     */
    @GetMapping("/sysMenu/findNodes")
    Result<List<SysMenuDo>> findNodes();

    @PostMapping("/sysMenu/save")
    Result<Boolean> save(@RequestBody SysMenuDo sysMenu);

    @PutMapping("/sysMenu/update")
    Result<Boolean> update(@RequestBody SysMenuDo permission);

    @DeleteMapping("/sysMenu/remove/{id}")
    Result<Boolean> remove(@PathVariable Long id);

    /**
     * 根据角色获取菜单
     *
     * @param roleId
     * @return
     */
    @GetMapping("/sysMenu/toAssign/{roleId}")
    Result<List<SysMenuDo>> toAssign(@PathVariable Long roleId);

    /**
     * 给角色分配权限
     *
     * @param assginMenuVo
     * @return
     */
    @PostMapping("/sysMenu/doAssign")
    Result<Boolean> doAssign(@RequestBody AssginMenuVo assginMenuVo);
}

