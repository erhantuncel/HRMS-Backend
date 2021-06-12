package springreact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.JobTypeService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.JobTypeDao;
import springreact.hrms.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService {

	private JobTypeDao jobTypeDao;
	
	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao) {
		super();
		this.jobTypeDao = jobTypeDao;
	}

	@Override
	public JobType findById(Integer id) {
		return this.jobTypeDao.findById(id).orElse(null);
	}

	@Override
	public DataResult<List<JobType>> getAll() {
		List<JobType> jobTypes = this.jobTypeDao.findAll();
		return new SuccessDataResult<List<JobType>>(jobTypes, "Job types are listed.");
	}

}
