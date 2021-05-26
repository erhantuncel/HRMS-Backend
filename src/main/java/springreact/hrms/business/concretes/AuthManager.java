package springreact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.AuthService;
import springreact.hrms.business.abstracts.CandidateService;
import springreact.hrms.business.abstracts.UserService;
import springreact.hrms.business.abstracts.VerificationCodeService;
import springreact.hrms.core.utilities.adapters.mernis.UserCheckService;
import springreact.hrms.core.utilities.business.BusinessRules;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.ErrorResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.core.utilities.results.SuccessResult;
import springreact.hrms.core.utilities.verifications.VerificationService;
import springreact.hrms.entities.concretes.Candidate;
import springreact.hrms.entities.concretes.VerificationCode;
import springreact.hrms.entities.dtos.CandidateForRegisterationDto;

@Service
public class AuthManager implements AuthService {
	
	UserService userService;
	UserCheckService mernisService;
	CandidateService candidateService;
	VerificationCodeService verificationCodeService;
	VerificationService verificationService;
	
	@Autowired
	public AuthManager(UserService userService, UserCheckService mernisService, CandidateService candidateService,
			VerificationCodeService verificationCodeService, VerificationService verificationService) {
		super();
		this.userService = userService;
		this.mernisService = mernisService;
		this.candidateService = candidateService;
		this.verificationCodeService = verificationCodeService;
		this.verificationService = verificationService;
	}

	@Override
	public Result registerCandidate(CandidateForRegisterationDto candidateDto) {
		Result businessResult = BusinessRules.run(
									checkIfAllFieldsNotBlank(candidateDto),
									confirmPassword(candidateDto.getPassword(), candidateDto.getPasswordForCheck()),
									checkIfRealPerson(candidateDto),
									checkIfEmailExists(candidateDto.getEmail()),
									checkIfIdentityNumberExists(candidateDto.getIdentityNumber())
								);
		
		if (businessResult != null) {
			return businessResult;
		}
		
		Candidate candidateToSave = new Candidate(0,candidateDto.getIdentityNumber(), 
				candidateDto.getFirstName(), candidateDto.getLastName(), 
				candidateDto.getEmail(), candidateDto.getYearOfBirth(), 
				candidateDto.getPassword());
		DataResult<Candidate> saveResult = candidateService.add(candidateToSave);
		
		if(saveResult.isSuccess()) {
			String email = saveResult.getData().getEmail();
			int userId = saveResult.getData().getId();
			Result sendVerificationResult = verificationService.sendVerification(email, 
					this.verificationCodeService.generateCode(userId).getData().getCode());
			if(sendVerificationResult.isSuccess()) {
				return new SuccessDataResult<Candidate>(saveResult.getData(), "Candidate is saved successfully and sent activation email.");
			}
		}
		
		return new ErrorResult("Candidate is not saved.");
	}
	
	@Override
	public Result verifyEmail(Integer userId, String code) {
		VerificationCode verificationCode = this.verificationCodeService.findByUserIdAndCode(userId, code);
		if(verificationCode != null) {
			verificationCode.setVerified(true);
			this.verificationCodeService.save(verificationCode);
			return new SuccessResult("Email is verified.");
		}
		return new ErrorResult("Email is not verified.");
	}
	
	private Result confirmPassword(String password, String passwordForConfirm) {
		if(password.equals(passwordForConfirm)) {
			return new SuccessResult();
		}
		return new ErrorResult("Passwords must be same.");
	}
	
	private Result checkIfAllFieldsNotBlank(CandidateForRegisterationDto candidateDto) {
		if (candidateDto.getFirstName().isBlank() || 
				candidateDto.getLastName().isBlank() || 
				candidateDto.getIdentityNumber().isBlank() || 
				candidateDto.getEmail().isBlank() || 
				candidateDto.getPassword().isBlank() || 
				candidateDto.getPasswordForCheck().isBlank() || 
				candidateDto.getYearOfBirth().isBlank()) {
			return new ErrorResult("All fields are required.");
		}
		return new SuccessResult();
	}
	
	private Result checkIfRealPerson(CandidateForRegisterationDto candidateDto) {
		if(this.mernisService.validate(candidateDto.getFirstName(), 
											candidateDto.getLastName(), 
											candidateDto.getIdentityNumber(), 
											candidateDto.getYearOfBirth()).isSuccess()) {
			return new SuccessResult();
		}
		return new ErrorResult("E-Government check is not successful.");
	}
	
	private Result checkIfEmailExists(String email) {
		if(this.userService.existsByEmail(email).isSuccess()) {
			return new ErrorResult("Email already exists.");
		}
		return new SuccessResult();
	}
	
	private Result checkIfIdentityNumberExists(String identityNumber) {
		if(this.candidateService.existsByIdentityNumber(identityNumber).isSuccess()) {
			return new ErrorResult("Identity number already exists.");
		}
		return new SuccessResult();
	}

	

}
