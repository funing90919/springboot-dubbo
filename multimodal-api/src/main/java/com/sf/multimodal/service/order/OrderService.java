package com.sf.multimodal.service.order;

import com.sf.multimodal.domain.OrderDO;
import com.sf.multimodal.exception.ServiceException;

import java.util.List;

/**
 * Created by Jacky on 2019/1/8 17:23.
 */
public interface OrderService {

    List<OrderDO> findOrderList(OrderDO order) throws ServiceException;

    OrderDO findOrderById(Integer id) throws ServiceException;

    Integer insertOrder(OrderDO order) throws ServiceException;
}
