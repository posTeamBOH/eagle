package com.choice.eagle.controller;

import java.util.HashMap;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.choice.eagle.entity.Order;
import com.choice.eagle.service.RorderService;

/**
 * 消息的接收者
 * 
 */

public class ConsumerMessageListener implements MessageListener{

	@Autowired
	RorderService rorderService;
	@SuppressWarnings("unchecked")
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		HashMap<String, Object> jsonString = new HashMap<>();
		try {
			jsonString = JSON.parseObject(textMessage.getText(), HashMap.class);
//			System.out.println("接收到消息了");
			String tableId = (String) jsonString.get("tableId");
			Order order = JSON.parseObject(jsonString.get("o").toString(), Order.class);
			HashMap<String, Integer> menuNum = JSON.parseObject(jsonString.get("menu").toString(), HashMap.class);
//			System.out.println("准备添加");
			rorderService.insertOrder(tableId, order, menuNum);
//			System.out.println("添加成功");
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
	

}
