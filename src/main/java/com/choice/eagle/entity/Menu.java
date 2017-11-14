package com.choice.eagle.entity;

import org.springframework.stereotype.Component;

/**
 * 菜单
 * @author mengq
 *
 */
@Component
public class Menu {
	private String menuId;
	private String cuisineId;
	private String menuName;
	private String menuMoney;
	private String menuDate;
	private String menuNum;
	private String menuFir;
	private String menuMate;
	private String menuRem;
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getCuisineId() {
		return cuisineId;
	}
	public void setCuisineId(String cuisineId) {
		this.cuisineId = cuisineId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuMoney() {
		return menuMoney;
	}
	public void setMenuMoney(String menuMoney) {
		this.menuMoney = menuMoney;
	}
	public String getMenuDate() {
		return menuDate;
	}
	public void setMenuDate(String menuDate) {
		this.menuDate = menuDate;
	}
	public String getMenuNum() {
		return menuNum;
	}
	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}
	public String getMenuFir() {
		return menuFir;
	}
	public void setMenuFir(String menuFir) {
		this.menuFir = menuFir;
	}
	public String getMenuMate() {
		return menuMate;
	}
	public void setMenuMate(String menuMate) {
		this.menuMate = menuMate;
	}
	public String getMenuRem() {
		return menuRem;
	}
	public void setMenuRem(String menuRem) {
		this.menuRem = menuRem;
	}
}
