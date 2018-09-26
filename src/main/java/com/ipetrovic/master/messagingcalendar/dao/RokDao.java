package com.ipetrovic.master.messagingcalendar.dao;

import java.math.BigInteger;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ipetrovic.master.messagingcalendar.model.Rok;

@Repository
public class RokDao extends Dao<Rok, Long>{

	public RokDao() {
		super(Rok.class);
	}
	
	public Rok dajRok(String naziv, Long godina) {
		
		
		Query query = entityManager.createNativeQuery("select * from Rok r"
                + " where r.naziv = :n and r.godina = :g");
		query.setParameter("n", naziv); 
		query.setParameter("g", godina); 
		
		
		Object[] result = (Object[]) query.getSingleResult(); 
		
		Rok r = new Rok(); 
		r.setRokId(((BigInteger) result[0]).longValue());
		r.setNazivRoka((String) result[1]);
		r.setGodina(((BigInteger) result[2]).longValue());
		
		
		return r; 
	}

}
