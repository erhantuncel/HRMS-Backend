package springreact.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.CandidateService;
import springreact.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping(path = "/api/candidates")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<?> addCandidate(@RequestBody @Valid Candidate candidate) {
		return ResponseEntity.ok(this.candidateService.save(candidate));
	}
	
	@GetMapping(path = "/getall")
	public ResponseEntity<?> getAllCandidates() {
		return ResponseEntity.ok(this.candidateService.getAll());
	}
	
}
