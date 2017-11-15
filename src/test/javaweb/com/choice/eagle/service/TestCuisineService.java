package com.choice.eagle.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.entity.Cuisine;

public class TestCuisineService extends BaseTest {

	@Autowired
	private CuisineService cuisineService;
	
	@Test
	public void testselectAllCuisines() {
		List<Cuisine> list = cuisineService.selectAllCuisines();
		assertEquals("C1001", list.get(0).getCuisineId());
	}
}
