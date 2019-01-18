package com.sf.multimodal.service.impl;

import com.github.pagehelper.PageHelper;
import com.sf.multimodal.constant.RespResultEnum;
import com.sf.multimodal.dao.OrderDao;
import com.sf.multimodal.domain.OrderDO;
import com.sf.multimodal.exception.ServiceException;
import com.sf.multimodal.service.order.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jacky on 2019/1/8 17:23
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<OrderDO> findOrderList(OrderDO order) throws ServiceException {
        PageHelper.startPage(1, 5);
        List<OrderDO> orderList;
        try {
            orderList = orderDao.findOrderList(order);
        } catch (Exception e) {
            LOGGER.error("分页查询失败:{}", e);
            throw new ServiceException(RespResultEnum.COMMON_ACCESS_DB_ERROR, "分页查询失败");
        }
        return orderList;
    }

    @Override
    public OrderDO findOrderById(Integer id) throws ServiceException {
        return orderDao.findOrderById(id);
    }

    @Override
    public Integer insertOrder(OrderDO order) throws ServiceException {
        return orderDao.insertOrder(order);
    }
}
