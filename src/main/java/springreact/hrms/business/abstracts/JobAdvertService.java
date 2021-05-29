package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {

	Result save(JobAdvert jobAdvert);
	DataResult<List<JobAdvert>> findByIsActive(Boolean isActive);
}
