package com.easy.micro.auth.service;

import com.easy.micro.common.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * auth和admin相互远程调用
 * auth调用micro-admin 查库，而admin login时调用auth获取token
 */
@FeignClient("micro-admin")
public interface UmsAdminService {

    @GetMapping("/admin/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);
}
