package springreact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

	List<Education> findByCandidateIdAndIsActive(Integer candidateId, Boolean isActive);
	List<Education> findByCandidateIdAndIsActiveOrderByEndDateDesc(Integer candidateId, Boolean isActive);
}
