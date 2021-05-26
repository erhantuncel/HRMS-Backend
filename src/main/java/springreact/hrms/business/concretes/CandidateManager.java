package springreact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.CandidateService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.CandidateDao;
import springreact.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<Candidate> add(Candidate candidate) {
		Candidate savedCandidate = this.candidateDao.save(candidate);
		return new SuccessDataResult<Candidate>(savedCandidate, "Candidate is saved.");
	}

	@Override
	public Result existsByIdentityNumber(String identityNumber) {
		return new Result(this.candidateDao.existsByIdentityNumber(identityNumber));
	}

	
}
