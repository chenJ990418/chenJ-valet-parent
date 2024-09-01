package com.chenJ.valet.mgr.service.impl;

import com.chenJ.valet.driver.client.DriverInfoFeignClient;
import com.chenJ.valet.mgr.service.DriverInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class DriverInfoServiceImpl implements DriverInfoService {

    @Resource
    private DriverInfoFeignClient driverInfoFeignClient;


}