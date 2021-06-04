package springreact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	
	List<JobExperience> findByResumeIdAndIsActive(Integer resumeId, Boolean isActive);
	List<JobExperience> findByResumeIdAndIsActiveOrderByEndDateDesc(Integer resumeId, Boolean isActive);
}
