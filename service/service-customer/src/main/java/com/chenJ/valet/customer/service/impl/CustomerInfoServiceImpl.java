package com.chenJ.valet.customer.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenJ.valet.common.execption.ValetException;
import com.chenJ.valet.common.result.ResultCodeEnum;
import com.chenJ.valet.customer.mapper.CustomerInfoMapper;
import com.chenJ.valet.customer.mapper.CustomerLoginLogMapper;
import com.chenJ.valet.customer.service.CustomerInfoService;
import com.chenJ.valet.model.entity.customer.CustomerInfoDo;
import com.chenJ.valet.model.entity.customer.CustomerLoginLogDo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfoDo> implements CustomerInfoService {

    @Resource
    private WxMaService wxMaService;
    @Resource
    private CustomerLoginLogMapper customerLoginLogMapper;

    /**
     * 条件：
     * 1、前端开发者appid与服务器端appid一致
     * 2、前端开发者必须加入开发者
     *
     * @param code
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Long login(String code) {
        String openId = "";
        try {
            // 获取openId
            WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(code);
            openId = sessionInfo.getOpenid();
            log.info("【小程序授权】openId={}", openId);
        } catch (Exception e) {
            log.error("【小程序授权失败】失败原因={}", e.getMessage());
            throw new ValetException(ResultCodeEnum.PHONE_CODE_ERROR);
        }
        // 通过openId判断是否是新用户
        CustomerInfoDo customerInfoDo = this.getOne(new LambdaQueryWrapper<CustomerInfoDo>().eq(CustomerInfoDo::getWxOpenId, openId));
        if (null == customerInfoDo) {
            customerInfoDo = new CustomerInfoDo();
            customerInfoDo.setNickname(String.valueOf(System.currentTimeMillis()));
            customerInfoDo.setAvatarUrl("https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
            customerInfoDo.setWxOpenId(openId);
            save(customerInfoDo);
        }
        //登录日志
        CustomerLoginLogDo customerLoginLog = new CustomerLoginLogDo();
        customerLoginLog.setCustomerId(customerInfoDo.getId());
        customerLoginLog.setMsg("小程序登录");
        customerLoginLogMapper.insert(customerLoginLog);
        return customerInfoDo.getId();
    }
}
