package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.JobAdvert;
import springreact.hrms.entities.dtos.JobAdvertForSaveDto;

public interface JobAdvertService {

	DataResult<JobAdvert> save(JobAdvert jobAdvert);
	Result save(JobAdvertForSaveDto jobAdvertDto);
}
