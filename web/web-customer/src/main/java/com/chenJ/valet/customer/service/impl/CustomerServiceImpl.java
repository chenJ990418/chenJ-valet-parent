package com.chenJ.valet.customer.service.impl;

import com.chenJ.valet.common.constant.RedisConstant;
import com.chenJ.valet.common.execption.ValetException;
import com.chenJ.valet.common.result.Result;
import com.chenJ.valet.common.result.ResultCodeEnum;
import com.chenJ.valet.customer.client.CustomerInfoFeignClient;
import com.chenJ.valet.customer.service.CustomerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerInfoFeignClient customerInfoFeignClient;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public String login(String code) {
        // 获取openId
        Result<Long> result = customerInfoFeignClient.login(code);
        if (result.getCode().intValue() != ResultCodeEnum.SUCCESS.getCode()) {
            throw new ValetException(result.getCode(), result.getMessage());
        }
        Long customerId = result.getData();
        if (null == customerId) {
            throw new ValetException(ResultCodeEnum.DATA_ERROR);
        }
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set(RedisConstant.USER_LOGIN_KEY_PREFIX + token, customerId.toString(), RedisConstant.USER_LOGIN_KEY_TIMEOUT, TimeUnit.SECONDS);
        return token;
    }
}
