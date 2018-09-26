package com.ipetrovic.master.messagingcalendar.dao;

import org.springframework.stereotype.Repository;

import com.ipetrovic.master.messagingcalendar.model.Rola;

@Repository
public class RolaDao extends Dao<Rola, Long> {

	public RolaDao() {
		super(Rola.class);
	}
}
