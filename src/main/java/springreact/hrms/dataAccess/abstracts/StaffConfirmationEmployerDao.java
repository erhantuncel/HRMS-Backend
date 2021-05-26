package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.StaffConfirmationEmployer;

public interface StaffConfirmationEmployerDao extends JpaRepository<StaffConfirmationEmployer, Integer>{

}
