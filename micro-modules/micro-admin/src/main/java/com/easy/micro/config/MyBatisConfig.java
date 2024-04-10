package com.easy.micro.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 *
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.easy.micro.mapper","com.easy.micro.dao"})
public class MyBatisConfig {
}
