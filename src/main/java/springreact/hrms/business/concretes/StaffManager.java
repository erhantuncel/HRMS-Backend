package springreact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.StaffService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.StaffDao;
import springreact.hrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService {

	private StaffDao staffDao;

	@Autowired
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}

	@Override
	public DataResult<Staff> save(Staff staff) {
		Staff savedStaff = this.staffDao.save(staff);
		return new SuccessDataResult<Staff>(savedStaff, "Staff is saved to db");
	}

	@Override
	public Staff findById(Integer id) {
		return this.staffDao.findById(id).orElse(null);
	}

}
