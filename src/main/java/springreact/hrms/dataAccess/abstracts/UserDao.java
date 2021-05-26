package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	boolean existsByEmail(String email);
}
