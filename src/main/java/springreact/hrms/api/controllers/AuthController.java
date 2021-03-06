package springreact.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.AuthService;
import springreact.hrms.entities.dtos.CandidateForRegisterationDto;
import springreact.hrms.entities.dtos.EmployerForRegistrationDto;

@RestController
@RequestMapping(path = "/api/auth")
@CrossOrigin
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping(path = "/registercandidate")
	public ResponseEntity<?> registerCandidate(@RequestBody @Valid CandidateForRegisterationDto candidateDto) {
		return ResponseEntity.ok(this.authService.registerCandidate(candidateDto));
	}
	
	@PostMapping(path = "/registeremployer")
	public ResponseEntity<?> registerEmployer(@RequestBody @Valid EmployerForRegistrationDto employerDto) {
		return ResponseEntity.ok(this.authService.registerEmployer(employerDto));
	}
	
	@GetMapping(path = "/verify-email/{userId}/{code}")
	public ResponseEntity<?> verifyEmail(@PathVariable("userId") Integer userId, 
								@PathVariable("code") String code) {
		return ResponseEntity.ok(this.authService.verifyEmail(userId, code));
	}
	
	@GetMapping(path = "/confirm-employer/{employerId}/{staffId}")
	public ResponseEntity<?> confirmEmployer(@PathVariable("employerId") Integer employerId,
								@PathVariable("staffId") Integer staffId) {
		return ResponseEntity.ok(this.authService.confirmEmployer(employerId, staffId));
	}
	
}
