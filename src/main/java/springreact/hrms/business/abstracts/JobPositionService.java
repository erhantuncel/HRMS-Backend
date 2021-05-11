package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
