package com.choice.eagle.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.entity.Menu;
import com.choice.eagle.entity.ObjectMap;
import com.choice.eagle.entity.Order;

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
		menu.setCuisineId("C1001");
		menu.setMenuDate("2012-01-02");
		menu.setMenuId("M1004");
		menu.setMenuName("终极菜品");
		menu.setMenuFir("ZZCP");
		menu.setMenuMate("33333333");
		menu.setMenuMoney("400");
		menu.setMenuNum("5");
		assertEquals(1, menuDao.insertMenu(menu));
	}
	
	@Test
	public void testdeleteByMenuId() {
		assertEquals(1, menuDao.deleteByMenuId("M1004"));
	}
	
	@Test
	public void testupdateMenu() {
		Menu menu = new Menu();
		menu.setCuisineId("C1001");
		menu.setMenuDate("2012-01-02");
		menu.setMenuId("M1004");
		menu.setMenuName("终极菜品");
		menu.setMenuFir("ZZCP");
		menu.setMenuMate("44444444");
		menu.setMenuMoney("400");
		menu.setMenuNum("5");
		assertEquals(1, menuDao.updateMenu(menu));
	}

	@Test
	public void testcountKinds() {
		assertEquals(4, menuDao.countKinds());
	}
	
	@Test
	public void testcountEmpty() {
		assertEquals(1, menuDao.countEmpty());
	}
	
	@Test
	public void testcountLess() {
		assertEquals(1, menuDao.countLess(4));
	}
	
	@Test
	public void testselectByRequire() {
		ObjectMap map = new ObjectMap();
		map.setMenuName("测试菜品");
		map.setBeginTime("2001-01-07");
		map.setEndTime("2015-01-07");
		List<Menu> list = menuDao.selectByRequire(map);
		assertEquals(1, list.size());
	}
}