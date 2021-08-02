package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.Skill;

public interface SkillService {

	DataResult<List<Skill>> getAll();
	DataResult<Skill> save(Skill skill);
}
