package com.chenJ.valet.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenJ.valet.model.entity.order.OrderInfoDo;
import com.chenJ.valet.order.mapper.OrderInfoMapper;
import com.chenJ.valet.order.service.OrderInfoService;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfoDo> implements OrderInfoService {


}
