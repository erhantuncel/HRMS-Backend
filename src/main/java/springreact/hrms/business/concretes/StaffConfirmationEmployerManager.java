package springreact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.StaffConfirmationEmployerService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.StaffConfirmationEmployerDao;
import springreact.hrms.entities.concretes.StaffConfirmationEmployer;

@Service
public class StaffConfirmationEmployerManager implements StaffConfirmationEmployerService {

	private StaffConfirmationEmployerDao staffConfirmationEmployerDao;

	@Autowired
	public StaffConfirmationEmployerManager(StaffConfirmationEmployerDao staffConfirmationEmployerDao) {
		super();
		this.staffConfirmationEmployerDao = staffConfirmationEmployerDao;
	}

	@Override
	public DataResult<StaffConfirmationEmployer> save(StaffConfirmationEmployer staffConfirmationEmployer) {
		StaffConfirmationEmployer savedConfirmation = this.staffConfirmationEmployerDao.save(staffConfirmationEmployer);
		return new SuccessDataResult<StaffConfirmationEmployer>(savedConfirmation, "Staff Confirmations is added.");
	}

}
