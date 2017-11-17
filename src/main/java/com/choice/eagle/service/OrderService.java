package com.choice.eagle.service;

import java.util.List;
import java.util.Map;

import com.choice.eagle.entity.Order;

public interface OrderService {
	//根据桌子查询订单
	List<Order> selectByTable(String tableId);	
	//根据条件查询订单
	List<Order> selectByRequire(String orderId, String beginTime, String endTime,int pageNo);
	
}
