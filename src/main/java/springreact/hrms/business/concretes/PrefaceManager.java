package springreact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.PrefaceService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.PrefaceDao;
import springreact.hrms.entities.concretes.Preface;

@Service
public class PrefaceManager implements PrefaceService {

	private PrefaceDao prefaceDao;
	
	@Autowired
	public PrefaceManager(PrefaceDao prefaceDao) {
		super();
		this.prefaceDao = prefaceDao;
	}

	@Override
	public DataResult<Preface> save(Preface preface) {
		Preface savedPreface = this.prefaceDao.save(preface);
		return new SuccessDataResult<Preface>(savedPreface, "Preface is saved to db.");
	}

	@Override
	public DataResult<List<Preface>> findByResumeId(int resumeId, boolean isActive) {
		List<Preface> prefaces = this.prefaceDao.findByResumeIdAndIsActive(resumeId, isActive);
		return new SuccessDataResult<List<Preface>>(prefaces, "Prefaces are listed.");
	}

}
