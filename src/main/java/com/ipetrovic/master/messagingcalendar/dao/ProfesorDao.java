package com.ipetrovic.master.messagingcalendar.dao;

import org.springframework.stereotype.Repository;

import com.ipetrovic.master.messagingcalendar.model.Profesor;

@Repository
public class ProfesorDao extends Dao<Profesor, Long>{

	public ProfesorDao() {
		super(Profesor.class);
	}

}
