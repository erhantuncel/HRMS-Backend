package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {

	Result save(JobAdvert jobAdvert);
}
