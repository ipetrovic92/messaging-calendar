package com.ipetrovic.master.messagingcalendar.jms;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.jms.JmsProperties.DeliveryMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {
	
	public static final String VIRTUAL_TOPIC_ROK = "VirtualTopic.ROK"; 
	public static final String VIRTUAL_TOPIC_PREDMET = "VirtualTopic.PREDMET"; 
	public static final String VIRTUAL_TOPIC_STUDENT = "VirtualTopic.STUDENT"; 
	
	@Value("${spring.activemq.broker-url}")
	private String DEFAULT_BROKER_URL;

	
	@Bean("rokTopic")
	public ActiveMQTopic rokTopic() {
		return new ActiveMQTopic(VIRTUAL_TOPIC_ROK); 
	}
	
	@Bean("predmetTopic")
	public ActiveMQTopic predmetTopic() {
		return new ActiveMQTopic(VIRTUAL_TOPIC_PREDMET); 
	}
	
	@Bean("studentTopic")
	public ActiveMQTopic studentTopic() {
		return new ActiveMQTopic(VIRTUAL_TOPIC_STUDENT); 
	}
	
	@Bean("topicJmsTemplate")
	public JmsTemplate topicJmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(cachingConnectionFactory());
		template.setPubSubDomain(true);
		template.setDeliveryMode(DeliveryMode.PERSISTENT.getValue());
		template.setDeliveryPersistent(true);
		template.setExplicitQosEnabled(true);
		template.setMessageConverter(jacksonJmsMessageConverter());
		return template;
	}

	@Bean("queueJmsTemplate")
	public JmsTemplate queueJmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(cachingConnectionFactory());
		template.setPubSubDomain(false);
		template.setDeliveryMode(DeliveryMode.PERSISTENT.getValue());
		template.setDeliveryPersistent(true);
		template.setTimeToLive(1000000);
		template.setMessageConverter(jacksonJmsMessageConverter());
		return template;
	}

	@Bean("topicListenerFactory")
	public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// This provides all boot's default to this factory, including the message
		// converter
		configurer.configure(factory, connectionFactory);
		factory.setPubSubDomain(true);
		factory.setSubscriptionDurable(true);
		factory.setClientId("Client ID Topic 1");
		// You could still override some of Boot's default if necessary.
		return factory;
	}

	@Bean("queueListenerFactory")
	public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		return connectionFactory;
	}

	@Bean
	public ConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setSessionCacheSize(100);
		connectionFactory.setTargetConnectionFactory(connectionFactory());
		return connectionFactory;
	}

}
