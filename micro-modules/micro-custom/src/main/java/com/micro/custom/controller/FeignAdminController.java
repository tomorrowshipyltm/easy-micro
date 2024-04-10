package com.micro.custom.controller;

import com.easy.micro.common.api.CommonResult;
import com.micro.custom.dto.UmsAdminLoginParam;
import com.micro.custom.service.FeignAdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Feign调用micro-admin接口示例
 */
@Api(tags = "FeignAdminController", description = "Feign调用micro-admin接口示例")
@RestController
@RequestMapping("/feign/admin")
public class FeignAdminController {
    @Autowired
    private FeignAdminService adminService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody UmsAdminLoginParam loginParam) {
        return adminService.login(loginParam);
    }

    @GetMapping("/getRoleList")
    public CommonResult getRoleList(){
        return adminService.getList();
    }
}
