package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer>{

}
