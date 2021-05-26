package springreact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.EmployerService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.EmployerDao;
import springreact.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<Employer> save(Employer employer) {
		Employer savedEmployer = this.employerDao.save(employer);
		return new SuccessDataResult<Employer>(savedEmployer, "Employer is added to db.");
	}

	@Override
	public Employer findById(Integer id) {
		return this.employerDao.findById(id).orElse(null);
	}
	
}
