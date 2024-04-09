package com.easy.micro.service.dataset;

import com.easy.micro.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 远程调用micro-dataset
 */
@FeignClient("micro-dataset")
public interface FeignDatasetService {

    @GetMapping("/dataset/list")
    CommonResult getDatasetList();
}
