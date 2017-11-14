package com.choice.eagle.service;

import java.util.List;

import com.choice.eagle.entity.Order;

public interface OrderService {
	//根据桌子查询订单
		List<Order> selectByTable(String tableId);	
}
