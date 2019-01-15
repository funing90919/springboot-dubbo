package com.sf.multimodal.service.impl;

import com.github.pagehelper.PageHelper;
import com.sf.multimodal.dao.OrderDao;
import com.sf.multimodal.domain.OrderDO;
import com.sf.multimodal.service.order.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jacky on 2019/1/8 17:23.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<OrderDO> findOrderList() {
        PageHelper.startPage(1,5);
        List<OrderDO> orderList = orderDao.findOrderList();
        return orderList;
    }

    @Override
    public OrderDO findOrderById(Integer id) {
        return orderDao.findOrderById(id);
    }

    @Override
    public Integer insertOrder(OrderDO order) {
        return orderDao.insertOrder(order);
    }
}
