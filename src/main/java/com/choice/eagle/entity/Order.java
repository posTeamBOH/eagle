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
	private double orderMoney;
	private double orderNum;
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
	public double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public double getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(double orderNum) {
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
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", tablesId=" + tablesId + ", orderDate=" + orderDate + ", orderMoney="
				+ orderMoney + ", orderNum=" + orderNum + ", orderType=" + orderType + ", orderRemark=" + orderRemark
				+ "]";
	}
	

}
