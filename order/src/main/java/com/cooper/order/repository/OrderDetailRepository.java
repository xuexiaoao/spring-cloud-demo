package com.cooper.order.repository;

import com.cooper.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xueao
 * @create 2018-05-13 15:34
 * @desc ${DESCRIPTION}
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
