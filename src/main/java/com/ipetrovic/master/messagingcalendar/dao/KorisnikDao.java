package com.ipetrovic.master.messagingcalendar.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ipetrovic.master.messagingcalendar.model.Korisnik;

@Repository
public class KorisnikDao extends Dao<Korisnik, Long>{

	public KorisnikDao() {
		super(Korisnik.class);
	}
	
	public Korisnik pronadjiKorisnika(String korisnickoIme) {
		Query q = entityManager.createQuery("from Korisnik where korisnickoIme = :korisnickoIme");
		q.setParameter("korisnickoIme", korisnickoIme); 
		return (Korisnik) q.getSingleResult(); 
	}

}
