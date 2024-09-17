package com.chenJ.valet.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenJ.valet.model.entity.customer.CustomerInfoDo;

public interface CustomerInfoService extends IService<CustomerInfoDo> {

    /**
     * 小程序登录方法
     *
     * @param code
     * @return token
     */
    Long login(String code);
}
