package com.choice.eagle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.choice.eagle.entity.Order;

public interface OrderDao {
	
	//根据桌子查询订单
	List<Order> selectByTable(String tableId);
	
	//根据条件查询订单
	List<Order> selectByRequire(Map<String, String> map);
	
}