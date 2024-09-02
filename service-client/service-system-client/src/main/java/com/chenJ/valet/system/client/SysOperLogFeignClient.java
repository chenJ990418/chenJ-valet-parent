package com.chenJ.valet.system.client;

import com.chenJ.valet.common.result.Result;
import com.chenJ.valet.model.entity.system.SysOperLogDo;
import com.chenJ.valet.model.query.system.SysOperLogQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 产品列表API接口
 * </p>
 *
 * @author qy
 */
@FeignClient(value = "service-system")
public interface SysOperLogFeignClient {

    @PostMapping("/sysOperLog/findPage/{page}/{limit}")
    public Result<PageVo<SysOperLogDo>> findPage(
            @PathVariable("page") Long page,
            @PathVariable("limit") Long limit,
            @RequestBody SysOperLogQuery sysOperLogQuery);

    @GetMapping("/sysOperLog/getById/{id}")
    Result<SysOperLogDo> getById(@PathVariable Long id);

    /**
     * 记录日志
     *
     * @param sysOperLog
     * @return
     */
    @PostMapping("/sysOperLog/saveSysLog")
    Result<Boolean> saveSysLog(@RequestBody SysOperLogDo sysOperLog);
}