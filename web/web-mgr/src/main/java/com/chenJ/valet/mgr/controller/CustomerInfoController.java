package com.chenJ.valet.mgr.controller;

import com.chenJ.valet.mgr.service.CustomerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/customer/info")
@SuppressWarnings({"unchecked", "rawtypes"})
public class CustomerInfoController {

    @Resource
    private CustomerInfoService customerInfoService;


}

