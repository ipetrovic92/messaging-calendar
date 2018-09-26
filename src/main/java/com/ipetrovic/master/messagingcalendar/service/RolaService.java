package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.RolaDao;
import com.ipetrovic.master.messagingcalendar.model.Rola;

@Service
public class RolaService extends com.ipetrovic.master.messagingcalendar.service.Service<Rola, Long> {

	private RolaDao dao;

	@Autowired
	public RolaService(RolaDao dao) {
		super(dao);
		this.dao = dao;
	}

}
