package com.chenJ.valet.customer.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : chenJ
 * @Project : chenJ-valet-parent
 * @Package : com.chenJ.valet.customer.config
 * @ClassName : WxMaProperties.java
 * @createTime : 2024/9/2 23:24
 * @Description :
 */
@Data
@Component
@Schema(description = "小程序相关配置")
@ConfigurationProperties(prefix = "wx.miniapp")
public class WxMaProperties {
    @Schema(description = "微信公众平台小程序的appId")
    private String appId;
    @Schema(description = "微信公众平台小程序api秘钥")
    private String secret;
}
