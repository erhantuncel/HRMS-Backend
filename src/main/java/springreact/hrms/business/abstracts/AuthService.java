package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.dtos.CandidateForRegisterationDto;
import springreact.hrms.entities.dtos.EmployerForRegistrationDto;

public interface AuthService {

	Result registerCandidate(CandidateForRegisterationDto candidateDto);
	Result registerEmployer(EmployerForRegistrationDto employerDto);
	Result verifyEmail(Integer userId, String code);
	Result confirmEmployer(Integer employerId, Integer staffId);
}
