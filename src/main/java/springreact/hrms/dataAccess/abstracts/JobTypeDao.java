package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.JobType;

public interface JobTypeDao extends JpaRepository<JobType, Integer>{

}
