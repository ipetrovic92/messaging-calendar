package com.ipetrovic.master.messagingcalendar.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ipetrovic.master.messagingcalendar.model.Korisnik;


public class MyUserPrincipal implements UserDetails {

    private static final long serialVersionUID = -5694665634575424841L;
    private Korisnik korisnik;

    public MyUserPrincipal(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Long getId() {
        return korisnik.getKorisnikId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority(korisnik.getRola().getNazivRole()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return korisnik.getLozinka(); 
    }

    @Override
    public String getUsername() {
        return korisnik.getKorisnickoIme(); 
    }

    public Korisnik getKorisnik() {
		return korisnik;
	}

	@Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
