package com.chenJ.valet.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenJ.valet.common.annotation.Log;
import com.chenJ.valet.common.enums.BusinessType;
import com.chenJ.valet.common.result.Result;
import com.chenJ.valet.common.util.MD5;
import com.chenJ.valet.model.entity.system.SysUserDo;
import com.chenJ.valet.model.query.system.SysUserQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.system.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@Tag(name = "用户管理")
@RestController
@RequestMapping("/sysUser")
@CrossOrigin
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @Operation(summary = "获取分页列表")
    @PostMapping("findPage/{page}/{limit}")
    public Result<PageVo<SysUserDo>> findPage(
            @Parameter(name = "page", description = "当前页码", required = true)
            @PathVariable Long page,

            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable Long limit,

            @Parameter(name = "userQuery", description = "查询对象", required = false)
            @RequestBody SysUserQuery sysUserQuery) {
        Page<SysUserDo> pageParam = new Page<>(page, limit);
        PageVo<SysUserDo> pageVo = sysUserService.findPage(pageParam, sysUserQuery);
        return Result.ok(pageVo);
    }

    @Operation(summary = "获取用户")
    @GetMapping("getById/{id}")
    public Result<SysUserDo> getById(@PathVariable Long id) {
        SysUserDo sysUser = sysUserService.getById(id);
        return Result.ok(sysUser);
    }

    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @Operation(summary = "保存用户")
    @PostMapping("save")
    public Result<Boolean> save(@RequestBody SysUserDo user) {
        user.setPassword(MD5.encrypt(user.getPassword()));
        return Result.ok(sysUserService.save(user));
    }

    @Operation(summary = "更新用户")
    @PutMapping("update")
    public Result<Boolean> updateById(@RequestBody SysUserDo sysUser) {
        return Result.ok(sysUserService.updateById(sysUser));
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("remove/{id}")
    public Result<Boolean> remove(@PathVariable Long id) {
        return Result.ok(sysUserService.removeById(id));
    }

    @Operation(summary = "更新状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result<Boolean> updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        sysUserService.updateStatus(id, status);
        return Result.ok(true);
    }
}

