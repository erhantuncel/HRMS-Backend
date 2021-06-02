package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	DataResult<JobExperience> save(JobExperience jobExperience);
	DataResult<List<JobExperience>> findByCandidateId(int candidateId, boolean isActive);
	DataResult<List<JobExperience>> findByCandidateIdOrderByEndDateDesc(Integer candidateId, boolean isActive);
}
