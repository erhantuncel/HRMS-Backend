package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<JobPosition> save(JobPosition jobPosition);
	DataResult<List<JobPosition>> getAll();
}
