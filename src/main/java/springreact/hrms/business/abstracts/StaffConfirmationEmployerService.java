package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.StaffConfirmationEmployer;

public interface StaffConfirmationEmployerService {

	DataResult<StaffConfirmationEmployer> save(StaffConfirmationEmployer staffConfirmationEmployer);
}
