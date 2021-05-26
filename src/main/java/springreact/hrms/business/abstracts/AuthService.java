package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.dtos.CandidateForRegisterationDto;

public interface AuthService {

	Result registerCandidate(CandidateForRegisterationDto candidateDto);
	Result verifyEmail(Integer userId, String code);
}
