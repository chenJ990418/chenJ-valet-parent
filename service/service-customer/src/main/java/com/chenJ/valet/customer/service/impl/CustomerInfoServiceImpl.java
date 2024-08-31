package com.chenJ.valet.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenJ.valet.customer.mapper.CustomerInfoMapper;
import com.chenJ.valet.customer.service.CustomerInfoService;
import com.chenJ.valet.model.entity.customer.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements CustomerInfoService {

}
