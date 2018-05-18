package com.cooper.order.server.service;

import com.cooper.order.server.dto.OrderDTO;

/**
 * @author xueao
 * @create 2018-05-13 15:43
 * @desc ${DESCRIPTION}
 **/
public interface OrderService {
	OrderDTO create(OrderDTO orderDTO);
}
