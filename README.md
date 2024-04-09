## 项目简介

`easy-micro`是一个简化微服务开发的脚手架，后端采用SpringBoot/SpringCloud+Oauth2+MyBatis、前端VUE，拥有完整的权限管理功能，开箱即用。


## 特性
- Less is More，仅包含网关和鉴权核心模块，方便业务扩展
- 权限功能完整，前端菜单和后端API资源动态授权


## 项目演示
![图1](./document/demo1.png)



## 技术架构
![技术架构图](./document/a1.png)

## 项目模块
````   
├── yc-gateway         // 网关服务 [8080]
├── yc-auth            // 认证服务 [8081]
├── yc-common          // 通用模块                      
├── yc-modules           // 微服务模块
│       └── yc-admin                              // 统一用户微服务 [9000]
│       └── yc-cms                                // 内容管理微服务 [9001]
├──pom.xml  
````
