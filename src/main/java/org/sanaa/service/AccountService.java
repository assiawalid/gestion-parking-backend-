package org.sanaa.service;

import org.sanaa.model.Role;
import org.sanaa.model.User;

public interface AccountService {
	public User save(User user);
	public Role saveRole(Role role);
	public void addRoleToUser(String username,String roleName);
	public User findUserByUserName(String usernam);

}
