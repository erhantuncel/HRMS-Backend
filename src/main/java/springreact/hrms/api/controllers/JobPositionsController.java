package springreact.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.JobPositionService;
import springreact.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@PostMapping(path = "/add")
	public ResponseEntity<?> saveJobPosition(@RequestBody @Valid JobPosition jobPosition) {
		return ResponseEntity.ok(this.jobPositionService.save(jobPosition));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllJobPositions() {
		return ResponseEntity.ok(this.jobPositionService.getAll());
	}
}
