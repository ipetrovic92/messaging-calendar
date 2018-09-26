package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.PredmetRokDao;
import com.ipetrovic.master.messagingcalendar.model.PredmetRok;
import com.ipetrovic.master.messagingcalendar.model.PredmetRokPK;

@Service
public class PredmetRokService extends com.ipetrovic.master.messagingcalendar.service.Service<PredmetRok, PredmetRokPK>{

	private PredmetRokDao dao; 
	
	@Autowired 
	public PredmetRokService(PredmetRokDao dao) {
		super(dao);
		this.dao = dao; 
	}

}
