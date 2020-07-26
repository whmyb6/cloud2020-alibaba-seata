package com.mywhm.springcloud.service;

import com.mywhm.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created by king on 2020/6/3 10:58 下午
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult decreaseStorage(@RequestParam(value ="productId") Long productId,@RequestParam(value="count") Integer count);
}
