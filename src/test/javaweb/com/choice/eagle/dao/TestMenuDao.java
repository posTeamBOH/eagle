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
		menu.setMenuDate("2015-01-02");
		menu.setMenuId("M1001");
		menu.setMenuName("风味茄子");
		menu.setMenuFir("CSCP");
		menu.setMenuMate("44444444");
		menu.setMenuMoney("400");
		menu.setMenuNum("6");
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
		List<Menu> list = menuDao.selectByRequire(null, "2016-01-01", "2018-01-01");
		assertEquals(3, list.size());
	}
	
	@Test
	public void testselectMenuIdByName() {
		assertEquals("M1005", menuDao.selectMenuIdByName("可乐"));
	}
	
	@Test
	public void testselectNameById() {
		Menu menu = menuDao.selectNameById("M1001");
		assertEquals("风味茄子", menu.getMenuName());
	}
}