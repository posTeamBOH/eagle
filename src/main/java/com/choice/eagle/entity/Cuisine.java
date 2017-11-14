package com.choice.eagle.entity;

import org.springframework.stereotype.Component;

/**
 * 菜品分类
 * @author mengq
 *
 */
@Component
public class Cuisine {
	private String cuisineId;
	private String cuisineName;
	public String getCuisineId() {
		return cuisineId;
	}
	public void setCuisineId(String cuisineId) {
		this.cuisineId = cuisineId;
	}
	public String getCuisineName() {
		return cuisineName;
	}
	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}
	
	
}
