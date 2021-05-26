package springreact.hrms.core.utilities.verifications;

import springreact.hrms.core.utilities.results.Result;

public interface VerificationService {

	Result sendVerification(String email, String code);
}
