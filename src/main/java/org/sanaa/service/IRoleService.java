package org.sanaa.service;

import java.util.List;

import org.sanaa.model.Role;

public interface IRoleService {
	public Role ajouterRole(Role role);
	public Role modifierRole(Role role);
	public void supprimerRole(Role role);
	public Role findById(int id);
	public List<Role> findAll();
}
