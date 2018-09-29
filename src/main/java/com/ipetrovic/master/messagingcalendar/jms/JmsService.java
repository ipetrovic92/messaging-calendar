package com.ipetrovic.master.messagingcalendar.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsService {

	@Autowired
	@Qualifier("topicJmsTemplate")
	JmsTemplate topicJmsTemplate; 
	
	@Autowired
	@Qualifier("queueJmsTemplate")
	JmsTemplate queueJmsTemplate; 
}
