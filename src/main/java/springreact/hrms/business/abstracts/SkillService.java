package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.Skill;

public interface SkillService {

	DataResult<Skill> save(Skill skill);
	DataResult<List<Skill>> findByCandidateId(int candidateId, boolean isActive);
}
