package com.chenJ.valet.driver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenJ.valet.driver.mapper.DriverInfoMapper;
import com.chenJ.valet.driver.service.DriverInfoService;
import com.chenJ.valet.model.entity.driver.DriverInfoDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class DriverInfoServiceImpl extends ServiceImpl<DriverInfoMapper, DriverInfoDo> implements DriverInfoService {


}