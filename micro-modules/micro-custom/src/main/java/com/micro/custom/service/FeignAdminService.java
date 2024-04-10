package com.micro.custom.service;

import com.easy.micro.common.api.CommonResult;
import com.micro.custom.dto.UmsAdminLoginParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 远程调用micro-admin
 */
@FeignClient("micro-admin")
public interface FeignAdminService {

    @PostMapping("/admin/login")
    CommonResult login(@RequestBody UmsAdminLoginParam loginParam);

    @GetMapping("/role/listAll")
    CommonResult getList();
}
