package com.cooper.order.controller;

import com.cooper.order.VO.ResultVO;
import com.cooper.order.converter.OrderForm2OrderDTOConverter;
import com.cooper.order.dto.OrderDTO;
import com.cooper.order.enums.ResultEnum;
import com.cooper.order.exception.OrderException;
import com.cooper.order.form.OrderForm;
import com.cooper.order.service.OrderService;
import com.cooper.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xueao
 * @create 2018-05-13 15:42
 * @desc ${DESCRIPTION}
 **/

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/create")
	public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
												BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
			log.error("【创建订单】参数不正确, orderForm={}", orderForm);
			throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
					bindingResult.getFieldError().getDefaultMessage());
		}
		// orderForm -> orderDTO
		OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
		if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
			log.error("【创建订单】购物车信息为空");
			throw new OrderException(ResultEnum.CART_EMPTY);
		}

		OrderDTO result = orderService.create(orderDTO);

		Map<String, String> map = new HashMap<>();
		map.put("orderId", result.getOrderId());
		return ResultVOUtil.success(map);
	}

}
