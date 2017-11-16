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
	int updateMenuStatus(@Param("orderId") String orderId,@Param("menuName") String menuName);
	
	//点击结账改变桌子，订单，订单联系表中的状态
	int updateAllStatus(String tablesId,String orderId);
}