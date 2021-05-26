package springreact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.JobPositionService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.ErrorDataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.JobPositionDao;
import springreact.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<JobPosition> save(JobPosition jobPosition) {
		if(this.jobPositionDao.existsByName(jobPosition.getName())) {
			return new ErrorDataResult<>("Job position is already exists.");
		}
		JobPosition savedJobPosition = this.jobPositionDao.save(jobPosition);
		return new SuccessDataResult<JobPosition>(savedJobPosition, "Job Position is saved to db.");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		List<JobPosition> jobPositions = this.jobPositionDao.findAll();
		return new SuccessDataResult<List<JobPosition>>(jobPositions, "Job positions are listed successfully.");
	}

}
