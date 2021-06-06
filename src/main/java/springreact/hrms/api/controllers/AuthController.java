package springreact.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.AuthService;
import springreact.hrms.entities.dtos.CandidateForRegisterationDto;
import springreact.hrms.entities.dtos.EmployerForRegistrationDto;

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
	public ResponseEntity<?> registerCandidate(@RequestBody @Valid CandidateForRegisterationDto candidateDto) {
		return ResponseEntity.ok(this.authService.registerCandidate(candidateDto));
	}
	
	@PostMapping(path = "/registeremployer")
	public ResponseEntity<?> registerEmployer(@RequestBody @Valid EmployerForRegistrationDto employerDto) {
		return ResponseEntity.ok(this.authService.registerEmployer(employerDto));
	}
	
	@GetMapping(path = "/verifyemail/{userId}/{code}")
	public ResponseEntity<?> verifyEmail(@RequestParam("userId") Integer userId, 
								@RequestParam("code") String code) {
		return ResponseEntity.ok(this.authService.verifyEmail(userId, code));
	}
	
	@PostMapping(path = "/confirmstaff/{employerId}/{staffId}")
	public ResponseEntity<?> confirmStaff(@RequestParam("employerId") Integer employerId,
								@RequestParam("staffId") Integer staffId) {
		return ResponseEntity.ok(this.authService.confirmEmployer(employerId, staffId));
	}
	
}
