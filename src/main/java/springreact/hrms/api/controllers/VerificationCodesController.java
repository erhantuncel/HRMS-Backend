package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.VerificationCodeService;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.VerificationCode;

@RestController
@RequestMapping(path = "/api/verificationcodes")
public class VerificationCodesController {

	private VerificationCodeService verificationCodeService;

	@Autowired
	public VerificationCodesController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}

	@PostMapping(path = "/add")
	public Result addVerification(@RequestBody VerificationCode verificationCode) {
		return this.verificationCodeService.save(verificationCode);
	}
}
