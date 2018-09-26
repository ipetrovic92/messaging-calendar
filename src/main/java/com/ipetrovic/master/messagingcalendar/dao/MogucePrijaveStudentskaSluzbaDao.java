package com.ipetrovic.master.messagingcalendar.dao;

import org.springframework.stereotype.Repository;

import com.ipetrovic.master.messagingcalendar.model.MogucePrijaveStudentskaSluzba;
import com.ipetrovic.master.messagingcalendar.model.MogucePrijaveStudentskaSluzbaPK;

@Repository
public class MogucePrijaveStudentskaSluzbaDao extends Dao<MogucePrijaveStudentskaSluzba, MogucePrijaveStudentskaSluzbaPK>{

	public MogucePrijaveStudentskaSluzbaDao() {
		super(MogucePrijaveStudentskaSluzba.class);
	}
	
}
