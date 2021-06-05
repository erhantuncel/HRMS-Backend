package springreact.hrms.core.verifications;

import org.springframework.stereotype.Service;

import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements VerificationService {

	@Override
	public Result sendVerification(String email, String code) {
		return new SuccessResult("Verification  e-mail has been sent to " + email 
									+ " code: " + code);
	}

}
