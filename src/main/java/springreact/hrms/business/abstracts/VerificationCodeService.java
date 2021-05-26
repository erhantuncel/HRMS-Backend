package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	DataResult<VerificationCode> save(VerificationCode code);
	DataResult<VerificationCode> generateCode(int userId);
	VerificationCode findByUserIdAndCode(Integer userId, String code);
}
