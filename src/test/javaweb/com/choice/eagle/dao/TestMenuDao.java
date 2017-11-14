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
	
	@Test
	public void testinsertMenu() {
		Menu menu = new Menu();
		menu.setCuisineId("C1004");
		menu.setMenuDate("2012-01-02");
		menu.setMenuId("M1003");
		menu.setMenuName("终极菜品");
		menu.setMenuFir("ZZCP");
		menu.setMenuMate("33333333");
		menu.setMenuMoney("400");
		menu.setMenuNum("5");
		menuDao.insertMenu(menu);
	}
}