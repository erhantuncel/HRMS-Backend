package springreact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.WorkLocationService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.WorkLocationDao;
import springreact.hrms.entities.concretes.WorkLocation;

@Service
public class WorkLocationManager implements WorkLocationService {

	private WorkLocationDao workLocationDao;
	
	@Autowired
	public WorkLocationManager(WorkLocationDao workLocationDao) {
		super();
		this.workLocationDao = workLocationDao;
	}

	@Override
	public WorkLocation findById(Integer id) {
		return this.workLocationDao.findById(id).orElse(null);
	}

	@Override
	public DataResult<List<WorkLocation>> getAll() {
		List<WorkLocation> workLocations = this.workLocationDao.findAll();
		return new SuccessDataResult<List<WorkLocation>>(workLocations, "Work Locations are listed.");
	}

}
