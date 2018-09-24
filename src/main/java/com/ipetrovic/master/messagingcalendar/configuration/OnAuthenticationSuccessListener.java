package com.ipetrovic.master.messagingcalendar.configuration;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class OnAuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent>{

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		System.err.println("***************************************************************************************");
	}

}
