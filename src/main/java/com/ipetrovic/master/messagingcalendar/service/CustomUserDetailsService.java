package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipetrovic.master.messagingcalendar.configuration.MyUserPrincipal;
import com.ipetrovic.master.messagingcalendar.model.Korisnik;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired private KorisnikService korisnikService; 
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String korisnickoIme) throws UsernameNotFoundException {
		Korisnik korisnik = korisnikService.pronadjiKorisnika(korisnickoIme); 
		if (korisnik == null) {
			throw new UsernameNotFoundException("Korisnik sa korisnickim imenom \"" + korisnickoIme + "\" nije pronadjen. ");
		}

		return new MyUserPrincipal(korisnik);
	}

}
