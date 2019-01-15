package com.sf.multimodal.service.impl;

import com.github.pagehelper.PageHelper;
import com.sf.multimodal.dao.UserDao;
import com.sf.multimodal.domain.OrderDO;
import com.sf.multimodal.domain.UserDO;
import com.sf.multimodal.service.order.OrderService;
import com.sf.multimodal.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jacky on 2019/1/7 17:15
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderService orderService;

    @Override
    public List<UserDO> findUserList() {
        PageHelper.startPage(1, 10);
        List<UserDO> userList = userDao.findUserList();
        OrderDO order = orderService.findOrderById(164617);
        System.out.println(order);
        return userList;
    }

    @Override
    public UserDO findUserById(Integer id) {
        return userDao.findUserById(id);
    }
}
