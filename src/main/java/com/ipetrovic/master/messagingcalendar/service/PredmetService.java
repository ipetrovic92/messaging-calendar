package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.PredmetDao;
import com.ipetrovic.master.messagingcalendar.model.Predmet;

@Service
public class PredmetService extends com.ipetrovic.master.messagingcalendar.service.Service<Predmet, String> {

	@Autowired PredmetDao predmetDao; 
	
	public PredmetService(PredmetDao dao) {
		super(dao);
	}

}
