package springreact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.JobAdvertService;
import springreact.hrms.core.utilities.business.BusinessRules;
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
