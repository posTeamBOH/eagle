package com.choice.eagle.service.iml;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choice.eagle.dao.OrderDao;
import com.choice.eagle.dao.RorderDao;
import com.choice.eagle.entity.Menu;
import com.choice.eagle.service.RorderService;

@Service
public class RorderServiceImpl implements RorderService{
	@Autowired
	private RorderDao rorderDao;
//	@Override
//	public List<Menu> selectMenuByOrderId(String orderId) {
//		
//		return  rorderDao.selectMenuByOrderId(orderId);
//	}

	@Override
	public void updateMenuStatus(String orderId) {
		// TODO Auto-generated method stub
		rorderDao.updateMenuStatus(orderId);
	}

}
