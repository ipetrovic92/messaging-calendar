package com.ipetrovic.master.messagingcalendar.dao;

import org.springframework.stereotype.Repository;

import com.ipetrovic.master.messagingcalendar.model.PredmetRok;
import com.ipetrovic.master.messagingcalendar.model.PredmetRokPK;

@Repository
public class PredmetRokDao extends Dao<PredmetRok, PredmetRokPK> {

	public PredmetRokDao() {
		super(PredmetRok.class);
	}

}
