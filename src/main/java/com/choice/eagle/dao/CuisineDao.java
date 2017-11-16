package com.choice.eagle.dao;

import com.choice.eagle.entity.Cuisine;
import java.util.List;


public interface CuisineDao {

	//查询所有的菜品种类
    List<Cuisine> selectAllCuisines();
    
    //根据菜品种类名称查询菜品种类编号
    String selectCuisineId(String cuisineName);

}