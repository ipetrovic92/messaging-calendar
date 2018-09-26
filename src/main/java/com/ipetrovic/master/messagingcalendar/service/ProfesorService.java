package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.ProfesorDao;
import com.ipetrovic.master.messagingcalendar.model.Profesor;

@Service
public class ProfesorService extends com.ipetrovic.master.messagingcalendar.service.Service<Profesor, Long> {

	private ProfesorDao profesorDao;

	@Autowired
	public ProfesorService(ProfesorDao dao) {
		super(dao);
		this.dao = dao;
	}

}
