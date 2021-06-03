package springreact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.Preface;

public interface PrefaceDao extends JpaRepository<Preface, Integer>{
	List<Preface> findByCandidateIdAndIsActive(Integer candidateId, boolean isActive);
}
