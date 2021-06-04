package springreact.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.JobExperienceService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.JobExperienceDao;
import springreact.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<JobExperience> save(JobExperience jobExperience) {
		jobExperience.setActive(true);
		jobExperience.setCreatedDate(new Date());
		JobExperience savedJobExperince = this.jobExperienceDao.save(jobExperience);
		return new SuccessDataResult<JobExperience>(savedJobExperince, "Job experience is saved to db.");
	}

	@Override
	public DataResult<List<JobExperience>> findByResumeId(int resumeId, boolean isActive) {
		List<JobExperience> jobExperiences = this.jobExperienceDao.findByResumeIdAndIsActive(resumeId, true);
		return new SuccessDataResult<List<JobExperience>>(jobExperiences, 
				"Job experiences for candidate id is listed.");
	}

	@Override
	public DataResult<List<JobExperience>> findByResumeIdOrderByEndDateDesc(Integer resumeId, boolean isActive) {
		List<JobExperience> jobExperiences = this.jobExperienceDao.findByResumeIdAndIsActiveOrderByEndDateDesc(resumeId, true);
		return new SuccessDataResult<List<JobExperience>>(jobExperiences, 
				"Job experiences for candidate id order by end date in descendin is listed.");
	}

}
