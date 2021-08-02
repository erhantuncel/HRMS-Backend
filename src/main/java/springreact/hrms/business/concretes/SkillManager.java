package springreact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.SkillService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.SkillDao;
import springreact.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService {

	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		List<Skill> skills = skillDao.findAll();
		return new SuccessDataResult<List<Skill>>(skills, "Skills are listed.");
	}
	
	@Override
	public DataResult<Skill> save(Skill skill) {
		Skill savedSkill = this.skillDao.save(skill);
		return new SuccessDataResult<Skill>(savedSkill, "Skill is saved to db.");
	}
}
