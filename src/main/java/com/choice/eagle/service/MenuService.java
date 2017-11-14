package com.choice.eagle.service;

import java.util.List;

import com.choice.eagle.entity.Menu;

public interface MenuService {

	//查询剩余数量为零的菜品
	List<Menu> selectByMenu();
	
	//根据菜的种类查询菜品名称、数量和价格
	List<Menu> selectByCuisine(String cuisineId);
	
	//根据菜名模糊查询
	List<Menu> selectByName(String name);
	
	//根据菜的编号查询菜的数量
	int countMenuById(String menuId);
}
