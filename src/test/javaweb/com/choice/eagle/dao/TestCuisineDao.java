package com.choice.eagle.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.entity.Cuisine;

public class TestCuisineDao extends BaseTest {

	@Autowired
	private CuisineDao cuisineDao;
	
	@Test
	public void testselectAllCuisines() {
		List<Cuisine> list = cuisineDao.selectAllCuisines();
		assertEquals("C1001", list.get(0).getCuisineId());
	}
}
