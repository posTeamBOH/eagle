package com.choice.eagle.entity;

import org.springframework.stereotype.Component;

/**
 * 订单
 * @author mengq
 *
 */
@Component
public class Order {
	private String orderId;
	private String tablesId;
	private String orderDate;
	private String orderMoney;
	private String orderNum;
	private String orderType;
	private String orderRemark;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTablesId() {
		return tablesId;
	}
	public void setTablesId(String tablesId) {
		this.tablesId = tablesId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

}
