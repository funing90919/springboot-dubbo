package com.sf.multimodal.controller;

import com.sf.multimodal.domain.OrderDO;
import com.sf.multimodal.service.order.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jacky on 2019/1/8 17:56.
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderDO> findOrderList() {
        return orderService.findOrderList();
    }
}
