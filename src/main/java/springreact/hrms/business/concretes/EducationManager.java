package springreact.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.EducationService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.EducationDao;
import springreact.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<Education> save(Education education) {
		education.setCreatedDate(new Date());
		education.setActive(true);
		Education savedEducation = this.educationDao.save(education);
		return new SuccessDataResult<Education>(savedEducation, "Education is saved to db.");
	}

	@Override
	public DataResult<List<Education>> findByResumeId(Integer resumeId, boolean isActive) {
		List<Education> educations = this.educationDao.findByResumeIdAndIsActiveOrderByEndDateDesc(resumeId, isActive);
		return new SuccessDataResult<List<Education>>(educations, "Educations are listed.");
	}

	@Override
	public DataResult<List<Education>> findByResumeIdOrderByEndDateDesc(Integer resumeId, boolean isActive) {
		List<Education> educations = this.educationDao.findByResumeIdAndIsActiveOrderByEndDateDesc(resumeId, isActive);
		return new SuccessDataResult<List<Education>>(educations, 
				"Educations ordered by end date in descending are listed.");
	}

}
