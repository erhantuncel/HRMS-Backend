package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

}
