package com.gonzalo.challenge.techforb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gonzalo.challenge.techforb.entitys.User;
import com.gonzalo.challenge.techforb.service.IServiceUser;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private IServiceUser userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = new User();
		if(username.contains("@")) {
			user = userService.findOneByEmail(username).orElse(null);
		}else if(username.matches("[0-9]+")) {
			user = userService.findOneByDni(username).orElse(null);
		}else {
			user = userService.findOneByUsername(username).orElse(null);
		}
		
		
		return new UserDetailsImpl(user);
	}
}
