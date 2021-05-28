package springreact.hrms.business.concretes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.CityService;
import springreact.hrms.business.abstracts.EmployerService;
import springreact.hrms.business.abstracts.JobAdvertService;
import springreact.hrms.business.abstracts.JobPositionService;
import springreact.hrms.core.utilities.business.BusinessRules;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.ErrorResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.core.utilities.results.SuccessResult;
import springreact.hrms.dataAccess.abstracts.JobAdvertDao;
import springreact.hrms.entities.concretes.City;
import springreact.hrms.entities.concretes.Employer;
import springreact.hrms.entities.concretes.JobAdvert;
import springreact.hrms.entities.concretes.JobPosition;
import springreact.hrms.entities.dtos.JobAdvertForSaveDto;

@Service
public class JobAdvertManager implements JobAdvertService {

	private EmployerService employerService;
	private JobPositionService jobPositionService;
	private CityService cityService;
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(EmployerService employerService, JobPositionService jobPositionService,
			CityService cityService, JobAdvertDao jobAdvertDao) {
		super();
		this.employerService = employerService;
		this.jobPositionService = jobPositionService;
		this.cityService = cityService;
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<JobAdvert> save(JobAdvert jobAdvert) {
		JobAdvert savedJobAdvert = this.jobAdvertDao.save(jobAdvert);
		return new SuccessDataResult<JobAdvert>(savedJobAdvert, "Job Advert is saved to db.");
	}

	@Override
	public Result save(JobAdvertForSaveDto jobAdvertDto) {
		Result businessResult = BusinessRules.run(checkIfAllFieldsNotBlank(jobAdvertDto));
		if(businessResult != null) {
			return businessResult;
		}
		
		Employer employer = this.employerService.findById(jobAdvertDto.getEmployerId());
		JobPosition jobPosition = this.jobPositionService.findById(jobAdvertDto.getJobPositionId());
		City city = this.cityService.findById(jobAdvertDto.getCityId());
		
		JobAdvert jobAdvertToSave = new JobAdvert(0, jobAdvertDto.getJobDefinition(), 
				jobAdvertDto.getMinSalary(), jobAdvertDto.getMaxSalary(), 
				jobAdvertDto.getOpenPositionCount(), jobAdvertDto.getDeadline(), 
				true, new Date(), employer, jobPosition, city);
		return this.save(jobAdvertToSave);
	}
	
	private Result checkIfAllFieldsNotBlank(JobAdvertForSaveDto jobAdvertForSaveDto) {
		if((jobAdvertForSaveDto.getCityId() <= 0 
				|| jobAdvertForSaveDto.getEmployerId() <= 0
				|| jobAdvertForSaveDto.getJobPositionId() <= 0 
				|| jobAdvertForSaveDto.getDeadline() == null
				|| jobAdvertForSaveDto.getJobDefinition().isBlank()
				|| jobAdvertForSaveDto.getOpenPositionCount()<=0)) {
			return new ErrorResult("All fields are required.");
		}
		return new SuccessResult();
	}

}
