package com.chenJ.valet.dispatch.client;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "service-dispatch")
public interface NewOrderFeignClient {


}