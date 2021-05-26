package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<Candidate> add(Candidate candidate);
	Result existsByIdentityNumber(String identityNumber);
}
