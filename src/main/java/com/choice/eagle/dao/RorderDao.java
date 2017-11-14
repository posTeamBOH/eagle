package com.choice.eagle.dao;

import java.util.List;
import com.choice.eagle.entity.Menu;


public interface RorderDao {
	
	//根据订单号查询订单的菜品及数量
	List<Menu> selectMenuByOrderId(String orderId); 
    
	//改变订单联系表中的菜品状态
	void updateMenuStatus(String rorderId);
	
}