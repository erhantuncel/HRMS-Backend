package springreact.hrms.business.concretes;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.VerificationCodeService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.VerificationCodeDao;
import springreact.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	VerificationCodeDao verificationCodeDao;

	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
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
		VerificationCode verificationCodeToSave = new VerificationCode(0, userId, uuid.toString(), false, true, new Date());
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
