package com.choice.eagle.service;

import java.util.List;

import com.choice.eagle.entity.Cuisine;

public interface CuisineService {
	List<Cuisine> selectAllCuisines();
	
	String selectCuisineId(String cuisineName);
}
