package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.StaffConfirmationJobAdvert;

public interface StaffConfirmationJobAdvertDao extends JpaRepository<StaffConfirmationJobAdvert, Integer> {

}
