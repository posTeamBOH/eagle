package com.choice.eagle.controller;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.choice.eagle.entity.Table;
import com.choice.eagle.service.ProducerService;
import com.choice.eagle.util.UuidUtil;

/**
 * 测试使用activeMQ
 * @author S_eve
 *
 */

@RequestMapping("jms")
@Controller
public class JmsTestController {
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;
	
	//发送数据
	@RequestMapping("/send")
	@ResponseBody
	public String  testSend() {
		Table table = new Table();
		table.setTablesId(UuidUtil.getTableId());
		table.setTablesType("0");
		
		
		System.out.println("俺要发送数据啦啦啦");
		producerService.sendMessage(destination, 
				JSON.toJSONString(table));
		
		return "jms exute complete";
	}
	
	
	

}













