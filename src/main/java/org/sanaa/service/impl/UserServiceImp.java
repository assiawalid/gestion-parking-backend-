package org.sanaa.service.impl;

import java.util.List;

import org.sanaa.dao.UserRepository;
import org.sanaa.model.User;
import org.sanaa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class UserServiceImp implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User ajouterUSer(User user) {
		return userRepository.save(user);
	}

	@Override
	public User modifierUSer(User user) {
		return userRepository.save(user);
	}

	@Override
	public void supprimerUSer(User user) {
		userRepository.delete(user);
	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id)!=null ? userRepository.findById(id).get() : null;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
