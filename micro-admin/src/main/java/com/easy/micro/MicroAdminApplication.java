package com.easy.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 应用启动入口
 * Created by macro on 2018/4/26.
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroAdminApplication.class, args);
    }
}
