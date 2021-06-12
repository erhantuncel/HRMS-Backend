package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.StaffConfirmationJobAdvert;

public interface StaffConfirmationJobAdvertService {

	DataResult<StaffConfirmationJobAdvert> save(StaffConfirmationJobAdvert staffConfirmationJobAdvert);
	DataResult<StaffConfirmationJobAdvert> confirmJobAdvert(Integer jobAdvertId, Integer staffId);
}
