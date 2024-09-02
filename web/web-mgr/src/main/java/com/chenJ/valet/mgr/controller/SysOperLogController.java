package com.chenJ.valet.mgr.controller;

import com.chenJ.valet.common.result.Result;
import com.chenJ.valet.common.util.AuthContextHolder;
import com.chenJ.valet.mgr.service.SysOperLogService;
import com.chenJ.valet.model.entity.system.SysOperLogDo;
import com.chenJ.valet.model.query.system.SysOperLogQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * @author qy
 */
@Tag(name = "系统操作日志管理")
@RestController
@RequestMapping(value = "/sysOperLog")
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysOperLogController {

    @Resource
    private SysOperLogService sysOperLogService;

    @Operation(summary = "获取分页列表")
    @PostMapping("{page}/{limit}")
    public Result findPage(
            @Parameter(name = "page", description = "当前页码", required = true)
            @PathVariable Long page,

            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable Long limit,

            @Parameter(name = "sysOperLogVo", description = "查询对象", required = false)
            @RequestBody SysOperLogQuery sysOperLogQuery) {
        return Result.ok(sysOperLogService.findPage(page, limit, sysOperLogQuery));
    }

    @Operation(summary = "获取")
    @GetMapping("getById/{id}")
    public Result getById(@PathVariable Long id) {
        SysOperLogDo sysOperLog = sysOperLogService.getById(id);
        return Result.ok(sysOperLog);
    }

    @Operation(summary = "记录日志")
    @PostMapping("saveSysLog")
    public Result saveSysLog(@RequestBody SysOperLogDo sysOperLog) {
        sysOperLog.setOperName(AuthContextHolder.getUserId() + "");
        sysOperLogService.saveSysLog(sysOperLog);
        return Result.ok();
    }

}

