package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
	DataResult<JobPosition> save(JobPosition jobPosition);
}
