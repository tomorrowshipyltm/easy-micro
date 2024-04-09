package com.easy.micro.controller.dataset;

import com.easy.micro.common.api.CommonResult;
import com.easy.micro.service.dataset.FeignDatasetService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feign调用micro-dataset接口
 */
@Api(tags = "FeignDatasetController", description = "Feign调用micro-dataset接口")
@RestController
@RequestMapping("/dataset")
public class FeignDatasetController {
    @Autowired
    private FeignDatasetService datasetService;

    @GetMapping("/list")
    public CommonResult queryDatasetList(){
        return datasetService.getDatasetList();
    }
}
