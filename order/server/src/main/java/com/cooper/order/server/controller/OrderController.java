package com.cooper.order.server.controller;

import com.cooper.order.server.VO.ResultVO;
import com.cooper.order.server.converter.OrderForm2OrderDTOConverter;
import com.cooper.order.server.dto.OrderDTO;
import com.cooper.order.server.enums.ResultEnum;
import com.cooper.order.server.exception.OrderException;
import com.cooper.order.server.form.OrderForm;
import com.cooper.order.server.service.OrderService;
import com.cooper.order.server.utils.ResultVOUtil;
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

	/**
	 * 1. 参数检验
	 * 2. 查询商品信息(调用商品服务)
	 * 3. 计算总价
	 * 4. 扣库存(调用商品服务)
	 * 5. 订单入库
	 */
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
