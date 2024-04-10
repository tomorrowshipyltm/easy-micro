## 项目简介

学习[mall]("https://github.com/macrozheng/mall")，致敬经典。`easy-micro`是一个简化微服务开发的脚手架，后端采用SpringBoot/SpringCloud+MyBatis+Oauth2、前端VUE，拥有完整的权限管理功能，开箱即用。


## 特性
- Less is More，核心模块仅包含网关和鉴权2个，方便业务定制扩展
- Gateway负责统一登录认证和访问控制，后端微服务安全无感。如需二层防护，requeustHeader获取userId/token即可
- Auth负责登录认证、返回token
- 接口文档清晰、调试可视化
- 前端VUE提供完整权限功能，动态控制菜单展示和API授权

## 技术架构
![技术架构图](./document/picture/architecture.png)

## 项目演示
![鉴权访问](./document/picture/token.png)


## 项目使用
- 安装mysql、redis和nacos即可运行，[部署文档](https://www.yuque.com/u1862689/owg1ex/bfltehvynfgccon9?singleDoc#qSteZ)
- 代码结构
````   
├── micro-gateway         // 网关服务 [8201]
├── micro-auth            // 认证服务 [9401]
├── micro-common          // 通用模块                      
├── micro-modules         // 业务模块
│       └── micro-admin                           // 聚合微服务/元数据服务，对接前端 [8080]
│       └── micro-demo                            // 用户业务微服务 
├──pom.xml  
````
## 技术选型

