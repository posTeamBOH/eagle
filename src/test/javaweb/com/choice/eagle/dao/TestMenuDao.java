package com.choice.eagle.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.entity.Menu;

public class TestMenuDao extends BaseTest{

	@Autowired
	private MenuDao menuDao;
	
	@Test
	public void testselectByCuisine() {
		List<Menu> list = menuDao.selectByCuisine("C1001");
		assertEquals(2, list.size());
	}
	
	@Test
	public void testselectByMenu() {
		List<Menu> list = menuDao.selectByMenu();
		assertEquals("M1002", list.get(0).getMenuId());
	}
	
	@Test
	public void testselectByName() {
		List<Menu> list = menuDao.selectByName("CS");
		assertEquals(2, list.size());
	}
	
	@Test
	public void testcountMenuById() {
		assertEquals(10, menuDao.countMenuById("M1001"));
	}
}
