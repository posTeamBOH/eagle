package com.choice.eagle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.choice.eagle.entity.Menu;
import com.choice.eagle.entity.MenuNum;

public interface RorderDao {
	
	//根据订单号查询订单的每个菜品及数量
	List<MenuNum> selectMenuByOrderId(String orderId); 
	
	//根据订单号查询订单的菜品总数量
	int countAllMenuByOrderId(String orderId);
    
	//点击上菜改变订单联系表中的菜品状态
	int updateMenuStatus(String orderId,String menuName);
	
	//根据桌子号改变桌子状态
	int updateTableStatus(@Param("tableId")String tableId, @Param("status")String status);

	//点击结账改变订单状态
	int updateOrderStatus(String orderId);

	//点击结账判断rorder中没上菜的个数
	int countNotUpdate(String orderId);
	
}