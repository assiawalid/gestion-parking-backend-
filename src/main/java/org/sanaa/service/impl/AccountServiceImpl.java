package org.sanaa.service.impl;

import java.util.ArrayList;

import org.sanaa.dao.RoleRepository;
import org.sanaa.dao.UserRepository;
import org.sanaa.model.Role;
import org.sanaa.model.User;
import org.sanaa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
     @Autowired
     private BCryptPasswordEncoder bcryptPasswordEncoder;
     @Autowired
     private UserRepository userRepository;
     @Autowired
     private RoleRepository roleRepository;
     
	@Override
	public User save(User user) {
		String hashPW=bcryptPasswordEncoder.encode(user.getPassword())	;
		user.setPassword(hashPW);
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		Role role=roleRepository.findByRole(roleName);
		User user=userRepository.findByUsername(username);
		if(user.getRoles()==null)
			user.setRoles(new ArrayList<Role>());
		user.getRoles().add(role);
		
		
	}

	@Override
	public User findUserByUserName(String usernam) {
		return userRepository.findByUsername(usernam);
	}

}
