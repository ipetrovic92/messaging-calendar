package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.Dao;
import com.ipetrovic.master.messagingcalendar.dao.ProfesorDao;
import com.ipetrovic.master.messagingcalendar.model.Profesor;

@Service
public class ProfesorService extends com.ipetrovic.master.messagingcalendar.service.Service<Profesor, Long>{

	@Autowired
	private ProfesorDao profesorDao; 
	
	public ProfesorService(ProfesorDao profesorDao) {
		super(profesorDao);
	}
	
}
