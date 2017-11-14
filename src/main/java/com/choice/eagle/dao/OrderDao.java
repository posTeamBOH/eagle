package com.choice.eagle.dao;

import java.util.List;
import java.util.Map;

import com.choice.eagle.entity.Order;

public interface OrderDao {
	
	//根据桌子查询订单
	List<Order> selectByTable(String tableId);
	
	//根据条件查询订单
	List<Order> selectByRequire(String orderId, String beginTime, String endTime);
	
	//根据条件统计订单时间和订单量
	Map<String, Integer> countByRequire(String orderId, String beginTime, String endTime);
}