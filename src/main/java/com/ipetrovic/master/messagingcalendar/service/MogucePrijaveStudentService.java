package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.MogucePrijaveStudentDao;
import com.ipetrovic.master.messagingcalendar.model.MogucePrijaveStudent;
import com.ipetrovic.master.messagingcalendar.model.MogucePrijaveStudentPK;

@Service
public class MogucePrijaveStudentService
		extends com.ipetrovic.master.messagingcalendar.service.Service<MogucePrijaveStudent, MogucePrijaveStudentPK> {

	private MogucePrijaveStudentDao dao;

	@Autowired
	public MogucePrijaveStudentService(MogucePrijaveStudentDao dao) {
		super(dao);
		this.dao = dao;
	}

}
