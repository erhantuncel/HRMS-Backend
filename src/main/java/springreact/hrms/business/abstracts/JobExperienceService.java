package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	DataResult<JobExperience> save(JobExperience jobExperience);
	DataResult<List<JobExperience>> findByResumeId(int resumeId, boolean isActive);
	DataResult<List<JobExperience>> findByResumeIdOrderByEndDateDesc(Integer resumeId, boolean isActive);
}
