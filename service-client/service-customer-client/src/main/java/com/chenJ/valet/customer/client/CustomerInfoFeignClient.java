package com.chenJ.valet.customer.client;

import com.chenJ.valet.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-customer")
public interface CustomerInfoFeignClient {

    /**
     * @param code 请求码
     * @return
     */
    @GetMapping("/customer/info/login/{code}")
    Result<Long> login(@PathVariable String code);
}