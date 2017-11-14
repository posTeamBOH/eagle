package com.choice.eagle.service.iml;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.dao.RorderDao;
import com.choice.eagle.service.RorderService;

public class RorderServiceImpl implements RorderService{
	@Autowired
	private RorderDao rorderDao;
	@Override
	public HashMap<String, Integer> selectMenuByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return  rorderDao.selectMenuByOrderId(orderId);
	}

	@Override
	public void updateMenuStatus(String orderId) {
		// TODO Auto-generated method stub
		rorderDao.updateMenuStatus(orderId);
	}

}
