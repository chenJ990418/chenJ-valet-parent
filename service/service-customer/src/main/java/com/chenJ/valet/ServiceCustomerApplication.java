package com.chenJ.valet;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@MapperScan(value = "com.chenJ.valet.customer.mapper")
public class ServiceCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCustomerApplication.class, args);
    }
}
