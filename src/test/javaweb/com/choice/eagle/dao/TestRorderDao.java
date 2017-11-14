package com.choice.eagle.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.entity.Menu;

public class TestRorderDao extends BaseTest {

	@Autowired
	private RorderDao rorderDao;
	
	@Test
	public void testselectMenuByOrderId() {
		List<Menu> list = rorderDao.selectMenuByOrderId("R1001");
		
	}
}
