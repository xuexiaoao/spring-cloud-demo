package com.cooper.order.server.converter;

import com.cooper.order.server.dataobject.OrderDetail;
import com.cooper.order.server.dto.OrderDTO;
import com.cooper.order.server.enums.ResultEnum;
import com.cooper.order.server.exception.OrderException;
import com.cooper.order.server.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 16:18
 * @desc ${DESCRIPTION}
 **/
@Slf4j
public class OrderForm2OrderDTOConverter {
	public static OrderDTO convert(OrderForm orderForm) {
		Gson gson = new Gson();
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBuyerName(orderForm.getName());
		orderDTO.setBuyerPhone(orderForm.getPhone());
		orderDTO.setBuyerAddress(orderForm.getAddress());
		orderDTO.setBuyerOpenid(orderForm.getOpenid());

		List<OrderDetail> orderDetailList = new ArrayList<>();
		try {
			orderDetailList = gson.fromJson(orderForm.getItems(),
					new TypeToken<List<OrderDetail>>() {
					}.getType());
		} catch (Exception e) {
			log.error("【json转换】错误, string={}", orderForm.getItems());
			throw new OrderException(ResultEnum.PARAM_ERROR);
		}
		orderDTO.setOrderDetailList(orderDetailList);

		return orderDTO;
	}
}
