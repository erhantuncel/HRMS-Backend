package springreact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.UserService;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.dataAccess.abstracts.UserDao;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result existsByEmail(String email) {
		return new Result(this.userDao.existsByEmail(email));
	}
}
