package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.User;

public interface UserService {
	User findById(int userId);
	Result existsByEmail(String email);
}
