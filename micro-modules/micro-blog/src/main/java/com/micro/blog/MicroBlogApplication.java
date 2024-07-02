package com.micro.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import xyz.erupt.core.annotation.EruptScan;

import java.awt.*;
import java.net.URI;

@EntityScan
// erupt特有标注
@EruptScan
@SpringBootApplication
public class MicroBlogApplication extends SpringBootServletInitializer {
    //详细使用方法详见项目内 README.md 文件说明
    public static void main(String[] args) {
        SpringApplication.run(MicroBlogApplication.class, args);
        try {
            System.setProperty("java.awt.headless", "false");
            // 启动后自动打开页面，注意端口需要与application.yml 配置一致
            Desktop.getDesktop().browse(new URI("http://localhost:9090"));
        } catch (Exception ignore) {
        }
        System.err.println("详细使用方法，请阅读：README.md");
    }

    //打WAR包的配置
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MicroBlogApplication.class);
    }
}

