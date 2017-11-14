package com.choice.eagle.dao;

import com.choice.eagle.entity.Menu;
import com.choice.eagle.entity.Order;

import java.util.List;
import java.util.Map;

public interface MenuDao {
	
	//查询剩余数量为零的菜品
	List<Menu> selectByMenu();
	
	//根据菜的种类查询菜品名称、数量和价格
	List<Menu> selectByCuisine(String cuisineId);
	
	//根据菜名模糊查询
	List<Menu> selectByName(String name);
	
	//根据菜的编号查询菜的数量
	int countMenuById(String menuId);
	
	//增
	void insertMenu(Menu menu);  
	
	//删
	void deleteByMenuId(String menuId);
	
	//改
	void updateMenu(Menu menu);
	
	//查
	//根据条件查询菜单（注意排序）
	List<Order> selectByRequire(String MenuId, String beginTime, String endTime);
		
	//计菜种类合计
	int countKinds();
	
	//统计菜品 空数
	int countEmpty();
	
	//余量不足的菜
	int countLess(int menuNum);
}


   