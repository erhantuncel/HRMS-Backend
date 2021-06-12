package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.WorkLocation;

public interface WorkLocationService {

	WorkLocation findById(Integer id);
	DataResult<List<WorkLocation>> getAll();
}
