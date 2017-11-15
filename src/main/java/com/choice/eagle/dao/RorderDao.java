package com.choice.eagle.dao;

import java.util.List;

import com.choice.eagle.entity.Menu;
import com.choice.eagle.entity.MenuNum;

public interface RorderDao {
	
	//根据订单号查询订单的每个菜品及数量
	List<MenuNum> selectMenuByOrderId(String orderId); 
	
	//根据订单号查询订单的菜品总数量
	int countAllMenuByOrderId(String orderId);
    
	//改变订单联系表中的菜品状态
	int updateMenuStatus(String rorderId);
	
	//根据订单号查询订单详情
}