package com.ipetrovic.master.messagingcalendar.jms;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ipetrovic.master.messagingcalendar.model.PredmetRok;
import com.ipetrovic.master.messagingcalendar.model.PredmetRokPK;
import com.ipetrovic.master.messagingcalendar.model.Profesor;
import com.ipetrovic.master.messagingcalendar.model.Rok;
import com.ipetrovic.master.messagingcalendar.service.ProfesorService;
import com.ipetrovic.master.messagingcalendar.service.RokService;

@Component
public class ZapamcenRokJMSListeners {
	@Autowired
	private RokService rokService; 
	
	@Autowired private ProfesorService profesorService; 

	@JmsListener(destination = "rok.dezurstva", containerFactory = "defaultQueueConnectionFactory")
	public void evidentirajDezurstva(String rokIdStr) {
		Long rokId = new Long(rokIdStr); 
		Rok r = rokService.find(rokId); 
	
		System.out.println("Upisi u bazu. ");
		
	}
}
