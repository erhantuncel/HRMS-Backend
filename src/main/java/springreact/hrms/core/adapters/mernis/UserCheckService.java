package springreact.hrms.core.adapters.mernis;

import springreact.hrms.core.utilities.results.Result;

public interface UserCheckService {

	Result validate(String firstName, String lastName, String identityNumber, String yearOfBirht);
}
