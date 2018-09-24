package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.RokDao;
import com.ipetrovic.master.messagingcalendar.model.Rok;

@Service
public class RokService extends com.ipetrovic.master.messagingcalendar.service.Service<Rok, Long> {

	@Autowired
	private RokDao dao;

	public RokService(RokDao dao) {
		super(dao);
	}

	public Rok dajRok(String naziv, Long godina) {
		return dao.dajRok(naziv, godina); 
	}
}
