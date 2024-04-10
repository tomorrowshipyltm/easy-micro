package com.easy.micro.controller;

import com.easy.micro.common.api.CommonResult;
import com.easy.micro.service.FeignCustomService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feign调用micro-custom接口
 */
@Api(tags = "FeignCustomController", description = "Feign调用micro-custom接口")
@RestController
@RequestMapping("/custom")
public class FeignCustomController {
    @Autowired
    private FeignCustomService customService;

    @GetMapping("/list")
    public CommonResult queryDataList(){
        return customService.getCustomList();
    }
}
