package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.MogucePrijaveStudentskaSluzbaDao;
import com.ipetrovic.master.messagingcalendar.model.MogucePrijaveStudentskaSluzba;
import com.ipetrovic.master.messagingcalendar.model.MogucePrijaveStudentskaSluzbaPK;

@Service
public class MogucePrijaveStudentskaSluzbaService extends
		com.ipetrovic.master.messagingcalendar.service.Service<MogucePrijaveStudentskaSluzba, MogucePrijaveStudentskaSluzbaPK> {

	private MogucePrijaveStudentskaSluzbaDao dao;

	@Autowired
	public MogucePrijaveStudentskaSluzbaService(MogucePrijaveStudentskaSluzbaDao dao) {
		super(dao);
		this.dao = dao;
	}

}
