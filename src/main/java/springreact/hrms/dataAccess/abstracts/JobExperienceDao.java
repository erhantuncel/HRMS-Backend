package springreact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	
	List<JobExperience> findByCandidateIdAndIsActive(Integer candidateId, Boolean isActive);
	List<JobExperience> findByCandidateIdAndIsActiveOrderByEndDateDesc(Integer candidateId, Boolean isActive);
}
