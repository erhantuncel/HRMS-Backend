package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.Staff;

public interface StaffService {

	DataResult<Staff> save(Staff staff);
	Staff findById(Integer id);
}
