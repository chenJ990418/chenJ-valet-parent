package com.chenJ.valet.system.client;

import com.chenJ.valet.common.result.Result;
import com.chenJ.valet.model.entity.system.SysDeptDo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "service-system")
public interface SysDeptFeignClient {

    @GetMapping("/sysDept/getById/{id}")
    Result<SysDeptDo> getById(@PathVariable Long id);

    @PostMapping("/sysDept/save")
    Result<Boolean> save(@RequestBody SysDeptDo sysDept);

    @PutMapping("/sysDept/update")
    Result<Boolean> update(@RequestBody SysDeptDo sysDept);

    @DeleteMapping("/sysDept/remove/{id}")
    Result<Boolean> remove(@PathVariable Long id);

    /**
     * 获取全部部门节点
     *
     * @return
     */
    @GetMapping("/sysDept/findNodes")
    Result<List<SysDeptDo>> findNodes();

    /**
     * 获取用户部门节点
     *
     * @return
     */
    @GetMapping("/sysDept/findUserNodes")
    Result<List<SysDeptDo>> findUserNodes();

    /**
     * 更新状态
     *
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/sysDept/updateStatus/{id}/{status}")
    Result<Boolean> updateStatus(@PathVariable Long id, @PathVariable Integer status);

}

