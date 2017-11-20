package com.choice.eagle.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.choice.eagle.dao.OrderDao;
import com.choice.eagle.entity.Order;
import com.choice.eagle.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	@Override
	public List<Order> selectByTable(String tableId) {
		// TODO Auto-generated method stub
		return orderDao.selectByTable(tableId);
	}
	@Override
	public List<Order> selectByRequire(String orderId, String beginTime, String endTime,int pageNo) {
		return orderDao.selectByRequire(orderId, beginTime, endTime,pageNo);
	}
	

}
