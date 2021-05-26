package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.AuthService;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.dtos.CandidateForRegisterationDto;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping(path = "/registercandidate")
	public Result registerCandidate(@RequestBody CandidateForRegisterationDto candidateDto) {
		return this.authService.registerCandidate(candidateDto);
	}
	
	@GetMapping("/verifyemail/{userId}/{code}")
	public Result verifyEmail(@RequestParam("userId") Integer userId, 
								@RequestParam("code") String code) {
		return this.authService.verifyEmail(userId, code);
	}
	
}
