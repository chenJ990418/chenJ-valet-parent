package com.chenJ.valet.model.entity.customer;

import com.chenJ.valet.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "CustomerCar")
public class CustomerCarDo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "客户ID")
    private Long customerId;

    @Schema(description = "车牌号")
    private String license;

    @Schema(description = "车型")
    private String brand;

}