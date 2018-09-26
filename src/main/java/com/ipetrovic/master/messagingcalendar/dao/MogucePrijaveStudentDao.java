package com.ipetrovic.master.messagingcalendar.dao;

import org.springframework.stereotype.Repository;

import com.ipetrovic.master.messagingcalendar.model.Korisnik;
import com.ipetrovic.master.messagingcalendar.model.MogucePrijaveStudent;
import com.ipetrovic.master.messagingcalendar.model.MogucePrijaveStudentPK;

@Repository
public class MogucePrijaveStudentDao extends Dao<MogucePrijaveStudent, MogucePrijaveStudentPK>{

	public MogucePrijaveStudentDao() {
		super(Korisnik.class);
	}
}
