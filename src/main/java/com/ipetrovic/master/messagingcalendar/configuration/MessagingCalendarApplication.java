package com.ipetrovic.master.messagingcalendar.configuration;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
@ComponentScan(basePackages = {"com.ipetrovic.master.messagingcalendar"})
public class MessagingCalendarApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MessagingCalendarApplication.class, args);
		
		JmsTemplate topicJmsTemplate = (JmsTemplate) context.getBean("topicJmsTemplate");
		JmsTemplate queueJmsTemplate = (JmsTemplate) context.getBean("queueJmsTemplate");
		
		ActiveMQTopic rokTopic = (ActiveMQTopic) context.getBean("rokTopic");

		// Send a message with a POJO - the template reuse the message converter
		System.out.println("Sending an email message.");
		topicJmsTemplate.convertAndSend(rokTopic, "Some message");
	}
}
