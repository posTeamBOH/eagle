package com.choice.eagle.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.dao.CuisineDao;
import com.choice.eagle.entity.Cuisine;
import com.choice.eagle.service.CuisineService;

public class CuisineServiceImpl implements CuisineService{
@Autowired
private CuisineDao cuisineDao;
	@Override
	public List<Cuisine> selectAllCuisines() {
		// TODO Auto-generated method stub
		return cuisineDao.selectAllCuisines();
	}

}
