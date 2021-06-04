package springreact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

	List<Education> findByResumeIdAndIsActive(Integer resumeId, Boolean isActive);
	List<Education> findByResumeIdAndIsActiveOrderByEndDateDesc(Integer resumeId, Boolean isActive);
}
