package com.chenJ.valet.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenJ.valet.common.result.Result;
import com.chenJ.valet.model.entity.system.SysPostDo;
import com.chenJ.valet.model.query.system.SysPostQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.system.service.SysPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "岗位管理")
@RestController
@RequestMapping(value = "/sysPost")
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysPostController {

    @Resource
    private SysPostService sysPostService;

    @Operation(summary = "获取分页列表")
    @PostMapping("findPage/{page}/{limit}")
    public Result<PageVo<SysPostDo>> findPage(
            @Parameter(name = "page", description = "当前页码", required = true)
            @PathVariable Long page,

            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable Long limit,

            @Parameter(name = "sysPostVo", description = "查询对象", required = false)
            @RequestBody SysPostQuery sysPostQuery) {
        Page<SysPostDo> pageParam = new Page<>(page, limit);
        PageVo<SysPostDo> pageVo = sysPostService.findPage(pageParam, sysPostQuery);
        return Result.ok(pageVo);
    }

    @Operation(summary = "获取")
    @GetMapping("getById/{id}")
    public Result<SysPostDo> getById(@PathVariable Long id) {
        SysPostDo sysPost = sysPostService.getById(id);
        return Result.ok(sysPost);
    }

    @GetMapping("findAll")
    public Result<List<SysPostDo>> findAll() {
        return Result.ok(sysPostService.findAll());
    }

    @Operation(summary = "新增")
    @PostMapping("save")
    public Result<Boolean> save(@RequestBody SysPostDo sysPost) {
        return Result.ok(sysPostService.save(sysPost));
    }

    @Operation(summary = "修改")
    @PutMapping("update")
    public Result<Boolean> update(@RequestBody SysPostDo sysPost) {
        return Result.ok(sysPostService.updateById(sysPost));
    }

    @Operation(summary = "删除")
    @DeleteMapping("remove/{id}")
    public Result<Boolean> remove(@PathVariable Long id) {
        return Result.ok(sysPostService.removeById(id));
    }

    @Operation(summary = "更新状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result<Boolean> updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        sysPostService.updateStatus(id, status);
        return Result.ok(true);
    }

}

