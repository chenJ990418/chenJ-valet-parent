package com.chenJ.valet.customer.service;

public interface CustomerService {


    /**
     * 小程序登录接口
     *
     * @param code
     * @return token
     */
    String login(String code);
}
