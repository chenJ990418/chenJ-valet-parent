package com.chenJ.valet.mgr.service.impl;

import com.chenJ.valet.customer.client.CustomerInfoFeignClient;
import com.chenJ.valet.mgr.service.CustomerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class CustomerInfoServiceImpl implements CustomerInfoService {

    @Resource
    private CustomerInfoFeignClient customerInfoFeignClient;


}
