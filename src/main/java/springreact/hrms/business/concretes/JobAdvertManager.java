package springreact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.JobAdvertService;
import springreact.hrms.core.business.BusinessRules;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.ErrorDataResult;
import springreact.hrms.core.utilities.results.ErrorResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.core.utilities.results.SuccessResult;
import springreact.hrms.dataAccess.abstracts.JobAdvertDao;
import springreact.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result save(JobAdvert jobAdvert) {
		Result businessResult = BusinessRules.run(checkIfAllFieldsNotBlank(jobAdvert));
		if(businessResult != null) {
			return businessResult;
		}
		JobAdvert savedJobAdvert = this.jobAdvertDao.save(jobAdvert);
		return new SuccessDataResult<JobAdvert>(savedJobAdvert, "Job Advert is saved.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> findByIsActive(Boolean isActive) {
		List<JobAdvert> jobAdverts = this.jobAdvertDao.findByIsActive(isActive);
		return new SuccessDataResult<List<JobAdvert>>(jobAdverts, "Job Adverts are listed.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> findByIsActiveOrderByCreatedDateAsc(Boolean isActive) {
		List<JobAdvert> jobAdverts = this.jobAdvertDao.findByIsActiveOrderByCreatedDateAsc(isActive);
		return new SuccessDataResult<List<JobAdvert>>(jobAdverts, 
				"Job Adverts are listed sorted by created date in ascending order.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> findByIsActiveOrderByCreatedDateDesc(Boolean isActive) {
		List<JobAdvert> jobAdverts = this.jobAdvertDao.findByIsActiveOrderByCreatedDateDesc(isActive);
		return new SuccessDataResult<List<JobAdvert>>(jobAdverts, 
				"Job Adverts are listed sorted by created date in descendin order.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> findByIsActiveAndEmployerId(Boolean isActive, Integer employerId) {
		List<JobAdvert> jobAdverts = this.jobAdvertDao.findByIsActiveAndEmployerId(isActive, employerId);
		return new SuccessDataResult<List<JobAdvert>>(jobAdverts, "Job Adverts are listed by Employer.");
	}
	
	@Override
	public DataResult<JobAdvert> changeIsActiveStatus(Integer jobAdvertId, Integer employerId) {
		JobAdvert jobAdvert = this.jobAdvertDao.findByIdAndEmployerId(jobAdvertId, employerId);
		if(jobAdvert == null) {
			return new ErrorDataResult<JobAdvert>("There is no job advert that matches this id and employer.");
		}
		jobAdvert.setActive(!jobAdvert.isActive());
		JobAdvert savedJobAdvert = this.jobAdvertDao.save(jobAdvert);
		return new SuccessDataResult<JobAdvert>(savedJobAdvert, "Job advert active status is changed.");
	}
	
	private Result checkIfAllFieldsNotBlank(JobAdvert jobAdvert) {
		if((jobAdvert.getCity() == null 
				|| jobAdvert.getEmployer() == null
				|| jobAdvert.getJobPosition() == null
				|| jobAdvert.getDeadline() == null
				|| jobAdvert.getJobDefinition().isBlank()
				|| jobAdvert.getOpenPositionCount()<=0)) {
			return new ErrorResult("All fields are required.");
		}
		return new SuccessResult();
	}

	
}
