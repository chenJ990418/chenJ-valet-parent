package com.chenJ.valet.mgr.service.impl;

import com.chenJ.valet.mgr.service.OrderInfoService;
import com.chenJ.valet.order.client.OrderInfoFeignClient;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class OrderInfoServiceImpl implements OrderInfoService {

    @Resource
    private OrderInfoFeignClient orderInfoFeignClient;


}
