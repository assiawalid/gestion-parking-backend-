package org.sanaa.service;

import java.util.List;

import org.sanaa.model.User;

public interface IUserService {
	public User ajouterUSer(User user);
	public User modifierUSer(User user);
	public void supprimerUSer(User user);
	public User findById(int id);
	public List<User> findAll();

}
