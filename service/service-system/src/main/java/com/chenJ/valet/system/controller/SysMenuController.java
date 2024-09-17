package com.chenJ.valet.system.controller;

import com.chenJ.valet.common.result.Result;
import com.chenJ.valet.model.entity.system.SysMenuDo;
import com.chenJ.valet.model.vo.system.AssginMenuVo;
import com.chenJ.valet.system.service.SysMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "菜单管理")
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;

    @Operation(summary = "获取菜单")
    @GetMapping("findNodes")
    public Result<List<SysMenuDo>> findNodes() {
        List<SysMenuDo> list = sysMenuService.findNodes();
        return Result.ok(list);
    }

    @Operation(summary = "新增菜单")
    @PostMapping("save")
    public Result<Boolean> save(@RequestBody SysMenuDo permission) {
        return Result.ok(sysMenuService.save(permission));
    }

    @Operation(summary = "修改菜单")
    @PutMapping("update")
    public Result<Boolean> update(@RequestBody SysMenuDo permission) {
        return Result.ok(sysMenuService.updateById(permission));
    }

    @Operation(summary = "删除菜单")
    @DeleteMapping("remove/{id}")
    public Result<Boolean> remove(@PathVariable Long id) {
        return Result.ok(sysMenuService.removeById(id));
    }

    @Operation(summary = "根据角色获取菜单")
    @GetMapping("toAssign/{roleId}")
    public Result<List<SysMenuDo>> toAssign(@PathVariable Long roleId) {
        List<SysMenuDo> list = sysMenuService.findSysMenuByRoleId(roleId);
        return Result.ok(list);
    }

    @Operation(summary = "给角色分配权限")
    @PostMapping("/doAssign")
    public Result<Boolean> doAssign(@RequestBody AssginMenuVo assginMenuVo) {
        sysMenuService.doAssign(assginMenuVo);
        return Result.ok(true);
    }
}

