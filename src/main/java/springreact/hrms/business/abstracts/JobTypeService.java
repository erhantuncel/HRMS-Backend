package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.JobType;

public interface JobTypeService {

	JobType findById(Integer id);
	DataResult<List<JobType>> getAll();
}
