package springreact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.JobAdvertService;
import springreact.hrms.business.abstracts.StaffConfirmationJobAdvertService;
import springreact.hrms.business.abstracts.StaffService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.StaffConfirmationJobAdvertDao;
import springreact.hrms.entities.concretes.JobAdvert;
import springreact.hrms.entities.concretes.Staff;
import springreact.hrms.entities.concretes.StaffConfirmationJobAdvert;

@Service
public class StaffConfirmationJobAdvertManager implements StaffConfirmationJobAdvertService {

	private StaffConfirmationJobAdvertDao staffConfirmationJobAdvertDao;
	private StaffService staffService;
	private JobAdvertService jobAdvertService;

	@Autowired
	public StaffConfirmationJobAdvertManager(StaffConfirmationJobAdvertDao staffConfirmationJobAdvertDao,
			StaffService staffService, JobAdvertService jobAdvertService) {
		super();
		this.staffConfirmationJobAdvertDao = staffConfirmationJobAdvertDao;
		this.staffService = staffService;
		this.jobAdvertService = jobAdvertService;
	}

	@Override
	public DataResult<StaffConfirmationJobAdvert> save(StaffConfirmationJobAdvert staffConfirmationJobAdvert) {
		StaffConfirmationJobAdvert confirmationJobAdvert 
			= this.staffConfirmationJobAdvertDao.save(staffConfirmationJobAdvert);
		return new SuccessDataResult<StaffConfirmationJobAdvert>(confirmationJobAdvert,
					"Staff confirmation for Job Advert is added.");
	}

	@Override
	public DataResult<StaffConfirmationJobAdvert> confirmJobAdvert(Integer jobAdvertId, Integer staffId) {
		JobAdvert jobAdvert = this.jobAdvertService.findById(jobAdvertId).getData();
		Staff staff = this.staffService.findById(staffId);
		StaffConfirmationJobAdvert staffConfirmationJobAdvert = new StaffConfirmationJobAdvert(0, staff, jobAdvert);
		DataResult<StaffConfirmationJobAdvert> saveResult = this.save(staffConfirmationJobAdvert);		
		jobAdvert.setActive(true);
		this.jobAdvertService.save(jobAdvert);
		return new SuccessDataResult<StaffConfirmationJobAdvert>(saveResult.getData(), saveResult.getMessage());
	}
	
	

}
