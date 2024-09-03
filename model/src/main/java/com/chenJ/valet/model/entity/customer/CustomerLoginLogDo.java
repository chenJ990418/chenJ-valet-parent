package com.chenJ.valet.model.entity.customer;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chenJ.valet.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "CustomerLoginLog")
@TableName(value = "customer_login_log")
public class CustomerLoginLogDo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "客户id")
    private Long customerId;

    @Schema(description = "登录IP地址")
    private String ipaddr;

    @Schema(description = "登录状态（0成功 1失败）")
    private Boolean status;

    @Schema(description = "提示信息")
    private String msg;

}