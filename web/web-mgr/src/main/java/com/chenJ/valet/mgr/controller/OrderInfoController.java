package com.chenJ.valet.mgr.controller;

import com.chenJ.valet.mgr.service.OrderInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Tag(name = "位置API接口管理")
@RestController
@RequestMapping(value = "/order/info")
@SuppressWarnings({"unchecked", "rawtypes"})
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;


}

