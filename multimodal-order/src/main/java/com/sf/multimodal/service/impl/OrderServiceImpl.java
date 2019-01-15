package com.sf.multimodal.service.impl;

import com.github.pagehelper.PageHelper;
import com.sf.multimodal.dao.OrderDao;
import com.sf.multimodal.domain.OrderDO;
import com.sf.multimodal.domain.UserDO;
import com.sf.multimodal.service.order.OrderService;
import com.sf.multimodal.service.user.UserService;

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

    @Autowired
    private UserService userService;


    @Override
    public List<OrderDO> findOrderList() {
        PageHelper.startPage(1,5);
        UserDO user = userService.findUserById(25);
        System.out.println(user);
        List<UserDO> userList = userService.findUserList();
        System.out.println(userList);
        return orderDao.findOrderList();
    }

    @Override
    public OrderDO findOrderById(Integer id) {
        return orderDao.findOrderById(id);
    }
}
