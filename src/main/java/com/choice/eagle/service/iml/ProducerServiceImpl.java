package com.choice.eagle.service.iml;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.choice.eagle.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(Destination destination, 
			final String messge) {
		jmsTemplate.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(messge);
			}
		});
	}

}
