package springreact.hrms.business.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.UserService;
import springreact.hrms.business.abstracts.VerificationCodeService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.VerificationCodeDao;
import springreact.hrms.entities.concretes.User;
import springreact.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	UserService userService;
	VerificationCodeDao verificationCodeDao;

	@Autowired
	public VerificationCodeManager(UserService userService, VerificationCodeDao verificationCodeDao) {
		super();
		this.userService = userService;
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public DataResult<VerificationCode> save(VerificationCode code) {
		VerificationCode savedVerificationCode = this.verificationCodeDao.save(code);
		return new SuccessDataResult<VerificationCode>(savedVerificationCode, "Verification Code is added.");
	}

	@Override
	public DataResult<VerificationCode> generateCode(int userId) {
		UUID uuid = UUID.randomUUID();
		User user = this.userService.findById(userId);
		VerificationCode verificationCodeToSave = new VerificationCode(0, user, uuid.toString(), false);
		return save(verificationCodeToSave);
	}

	@Override
	public VerificationCode findByUserIdAndCode(Integer userId, String code) {
		VerificationCode verificationCode = this.verificationCodeDao.findByUserIdAndCode(userId, code);
		if(verificationCode != null) {
			return verificationCode;
		}
		return null;
	}
}
