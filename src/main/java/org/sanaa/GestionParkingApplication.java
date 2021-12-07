package org.sanaa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionParkingApplication implements CommandLineRunner {
	@Autowired
	RepositoryRestConfiguration restConfig;

	@Autowired
	//private AccountService acc;
	public static void main(String[] args) {
		SpringApplication.run(GestionParkingApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		User s=new User();
//		s.setUsername("sana");
//		
//		s.setPassword("123");
//		acc.save(s);
//		Role role1=new Role();
//		Role role2=new Role();
//		role1.setRole("ADMIN");
//		role2.setRole("USER");
//		acc.saveRole(role1);
//        acc.saveRole(role2);
//        acc.addRoleToUser("admin","ADMIN");
//        acc.addRoleToUser("admin","USER");
//        acc.addRoleToUser("user","USER");
		
	}

}
