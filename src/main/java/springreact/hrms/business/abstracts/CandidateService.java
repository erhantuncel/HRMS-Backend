package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<Candidate> save(Candidate candidate);
	Result existsByIdentityNumber(String identityNumber);
	Candidate findById(int userId);
	DataResult<List<Candidate>> getAll();
}
