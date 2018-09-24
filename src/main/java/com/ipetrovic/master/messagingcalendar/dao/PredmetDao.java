package com.ipetrovic.master.messagingcalendar.dao;

import org.springframework.stereotype.Repository;

import com.ipetrovic.master.messagingcalendar.model.Predmet;

@Repository
public class PredmetDao extends Dao<Predmet, String>{

	public PredmetDao() {
		super(Predmet.class);
	}

}
