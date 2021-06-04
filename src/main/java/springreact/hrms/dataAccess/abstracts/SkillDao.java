package springreact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {
	List<Skill> findByResumeIdAndIsActive(Integer resumeId, boolean isActive);
}
