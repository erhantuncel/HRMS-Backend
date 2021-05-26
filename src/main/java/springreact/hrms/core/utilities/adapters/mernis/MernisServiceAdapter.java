package springreact.hrms.core.utilities.adapters.mernis;

import org.springframework.stereotype.Service;

import springreact.hrms.core.utilities.results.ErrorResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.core.utilities.results.SuccessResult;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public Result validate(String firstName, String lastName, String identityNumber, String yearOfBirht) {
		if(firstName.equals("notvalidfirstname") && lastName.equals("notvalidlastname")
				&& identityNumber.equals("00000000000") && yearOfBirht.equals("0000")) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

}
