package org.sanaa.service.impl;

import java.util.Collection;
import java.util.HashSet;

import org.sanaa.model.User;
import org.sanaa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailService implements UserDetailsService {
	
    @Autowired
    private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u=accountService.findUserByUserName(username);
		if(u==null) throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities=new HashSet<>();
		u.getRoles().forEach(role->{
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		});
		
		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), authorities);
	}

}
