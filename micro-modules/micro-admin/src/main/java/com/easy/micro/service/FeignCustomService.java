package com.easy.micro.service;

import com.easy.micro.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 远程调用micro-custom
 */
@FeignClient("micro-custom")
public interface FeignCustomService {

    @GetMapping("/custom/list")
    CommonResult getCustomList();
}
