package org.sanaa.controller;

import java.util.List;

import org.sanaa.model.User;
import org.sanaa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	IUserService userService;

	@PostMapping
	public User ajouterUser(@RequestBody User user) {
		return userService.ajouterUSer(user);

	}

	@PutMapping
	public User modifierUser(@RequestBody User user) {
		return userService.modifierUSer(user);
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable("id") int id) {
		return userService.findById(id);
	}

	@GetMapping
	public List<User> getAll() {
		return userService.findAll();
	}

	@DeleteMapping
	public void deleteUser(@RequestBody User user) {
		userService.supprimerUSer(user);
	}

}
