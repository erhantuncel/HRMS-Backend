package springreact.hrms.core.verifications;

import springreact.hrms.core.utilities.results.Result;

public interface VerificationService {

	Result sendVerification(String email, String code);
}
