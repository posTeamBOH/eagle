package com.choice.eagle.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.dao.OrderDao;
import com.choice.eagle.entity.Order;
import com.choice.eagle.service.OrderService;

public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	@Override
	public List<Order> selectByTable(String tableId) {
		// TODO Auto-generated method stub
		return orderDao.selectByTable(tableId);
	}

}
