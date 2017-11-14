package com.choice.eagle.dao;

import java.util.HashMap;

public interface RorderDao {
	
	//根据订单号查询订单的菜品及数量
	HashMap<String, Integer> selectMenuByOrderId(String orderId); 
    
	//改变订单联系表中的菜品状态
	int updateMenuStatus(String rorderId);
	
}