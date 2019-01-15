package com.sf.multimodal.service.order;

import com.sf.multimodal.domain.OrderDO;

import java.util.List;

/**
 * Created by Jacky on 2019/1/8 17:23.
 */
public interface OrderService {

    List<OrderDO> findOrderList();

    OrderDO findOrderById(Integer id);

    Integer insertOrder(OrderDO order);
}
