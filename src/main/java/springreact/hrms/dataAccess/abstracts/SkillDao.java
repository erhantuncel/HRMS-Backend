package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {
	
}
