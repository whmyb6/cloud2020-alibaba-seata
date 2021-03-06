package com.mywhm.springcloud.controller;

import com.mywhm.springcloud.domain.CommonResult;
import com.mywhm.springcloud.domain.Order;
import com.mywhm.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by king on 2020/6/3 10:48 下午
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}
