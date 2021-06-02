package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.Education;

public interface EducationService {

	DataResult<Education> save(Education education);
	DataResult<List<Education>> findByCandidateId(Integer candidateId, boolean isActive);
	DataResult<List<Education>> findByCandidateIdOrderByEndDateDesc(Integer candidateId, boolean isActive);
}
