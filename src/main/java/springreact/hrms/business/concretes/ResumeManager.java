package springreact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.JobPositionService;
import springreact.hrms.business.abstracts.ResumeService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.ResumeDao;
import springreact.hrms.entities.concretes.Education;
import springreact.hrms.entities.concretes.JobExperience;
import springreact.hrms.entities.concretes.JobPosition;
import springreact.hrms.entities.concretes.Language;
import springreact.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private JobPositionService jobPositionService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, JobPositionService jobPositionService) {
		super();
		this.resumeDao = resumeDao;
		this.jobPositionService = jobPositionService;
	}

	@Override
	public DataResult<Resume> save(Resume resume) {
		setResumeToRelatedEntities(resume);
		Resume savedResume = this.resumeDao.save(resume);
		return new SuccessDataResult<Resume>(savedResume, "Resume is saved to db.");
	}
	
	@Override
	public DataResult<List<Resume>> findByCandidateId(Integer candidateId, boolean isActive) {
		List<Resume> resumes = this.resumeDao.findByCandidateIdAndIsActive(candidateId, isActive);
		return new SuccessDataResult<List<Resume>>(resumes, "Resumes are listed.");
	}
	
	private void setResumeToRelatedEntities(Resume resume) {
		if(resume.getEducations() != null) {			
			for(Education education : resume.getEducations()) {
				education.setResume(resume);
			}
		}
		if(resume.getJobExperiences() != null) {			
			for(JobExperience jobExperience : resume.getJobExperiences()) {
				JobPosition jobPosition = jobExperience.getJobPosition();
				if(jobPosition.getId() == 0) {
					int jobPositionId = this.jobPositionService.save(jobPosition).getData().getId();
					jobExperience.getJobPosition().setId(jobPositionId);
				}
				jobExperience.setResume(resume);
			}
		}
		if(resume.getLanguages() != null) {			
			for(Language language : resume.getLanguages()) {
				language.setResume(resume);
			}
		}
	}

}
