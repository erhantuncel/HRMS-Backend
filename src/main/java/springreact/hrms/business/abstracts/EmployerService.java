package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<Employer> save(Employer employer);
	Employer findById(Integer id);
	DataResult<List<Employer>> getAll();
}
