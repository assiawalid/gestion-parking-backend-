package org.sanaa.dao;

import org.sanaa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}
