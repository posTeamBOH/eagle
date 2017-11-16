package com.choice.eagle.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;

public class TestRorderService extends BaseTest {

	@Autowired
	private RorderService rorderService;
	
	@Test
	public void testupdateAllStatus() {
		assertEquals(1, rorderService.updateAllStatus("T1001", "O1001"));
	}
}
