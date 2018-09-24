package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.PredmetRokDao;
import com.ipetrovic.master.messagingcalendar.model.PredmetRok;
import com.ipetrovic.master.messagingcalendar.model.PredmetRokPK;

@Service
public class PredmetRokService extends com.ipetrovic.master.messagingcalendar.service.Service<PredmetRok, PredmetRokPK>{

	@Autowired PredmetRokDao predmetRokDao; 
	
	public PredmetRokService(PredmetRokDao predmetRokDao) {
		super(predmetRokDao);
	}

}
