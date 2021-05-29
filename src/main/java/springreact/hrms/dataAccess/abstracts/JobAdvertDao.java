package springreact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	List<JobAdvert> findByIsActive(Boolean isActive);
	List<JobAdvert> findByIsActiveOrderByCreatedDateAsc(Boolean isActive);
	List<JobAdvert> findByIsActiveOrderByCreatedDateDesc(Boolean isActive);
	List<JobAdvert> findByIsActiveAndEmployerId(Boolean isActive, Integer employerId);
	JobAdvert findByIdAndEmployerId(Integer id, Integer employerId);
}
