package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipetrovic.master.messagingcalendar.configuration.MyUserPrincipal;
import com.ipetrovic.master.messagingcalendar.model.User;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService adminService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User admin = adminService.findUserByEmail(email);
		if (admin == null) {
			throw new UsernameNotFoundException("Username not found");
		}

		return new MyUserPrincipal(admin);
	}

}
