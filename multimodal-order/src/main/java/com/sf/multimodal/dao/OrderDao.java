package com.sf.multimodal.dao;

import com.sf.multimodal.domain.OrderDO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jacky on 2019/1/8 17:46.
 */

@Mapper
public interface OrderDao {

    List<OrderDO> findOrderList(OrderDO order);

    OrderDO findOrderById(Integer id);

    int insertOrder(OrderDO order);
}
