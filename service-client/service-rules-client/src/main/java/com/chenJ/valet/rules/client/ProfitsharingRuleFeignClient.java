package com.chenJ.valet.rules.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-rules")
public interface ProfitsharingRuleFeignClient {


}