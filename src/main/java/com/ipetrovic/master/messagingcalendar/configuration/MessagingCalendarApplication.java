package com.ipetrovic.master.messagingcalendar.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class MessagingCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingCalendarApplication.class, args);
	}
}
