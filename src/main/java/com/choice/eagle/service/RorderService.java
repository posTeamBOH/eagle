package com.choice.eagle.service;

import java.util.Map;

public interface RorderService {
	//根据订单号查询订单的菜品及数量
		Map<String, Integer> selectMenuByOrderId(String orderId); 
	    
		//改变订单联系表中的菜品状态
		void updateMenuStatus(String orderId);
}
