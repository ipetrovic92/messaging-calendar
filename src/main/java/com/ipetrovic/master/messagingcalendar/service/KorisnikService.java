package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.KorisnikDao;
import com.ipetrovic.master.messagingcalendar.model.Korisnik;

@Service
public class KorisnikService extends com.ipetrovic.master.messagingcalendar.service.Service<Korisnik, Long>{

	private KorisnikDao dao; 
	
	@Autowired 
	public KorisnikService(KorisnikDao dao) {
		super(dao);
		this.dao = dao; 
	}
	
	public Korisnik pronadjiKorisnika(String korisnickoIme) {
		return dao.pronadjiKorisnika(korisnickoIme);  
	}

}
