package org.sanaa.service.impl;

import java.util.List;

import org.sanaa.dao.RoleRepository;
import org.sanaa.model.Role;
import org.sanaa.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
    @Autowired
    RoleRepository roleRepository;
	@Override
	public Role ajouterRole(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public Role modifierRole(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public void supprimerRole(Role role) {
		roleRepository.delete(role);
		
	}

	@Override
	public Role findById(int id) {
		
		return roleRepository.findById(id).get();
	}

	@Override
	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}

}
