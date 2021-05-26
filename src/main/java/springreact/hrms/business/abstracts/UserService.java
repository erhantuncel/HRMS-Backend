package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.Result;

public interface UserService {
	Result existsByEmail(String email);
}
