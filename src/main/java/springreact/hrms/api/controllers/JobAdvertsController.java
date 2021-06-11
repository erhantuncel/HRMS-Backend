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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.JobAdvertService;
import springreact.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping(path = "/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping(path = "/add")
	public ResponseEntity<?> add(@RequestBody @Valid JobAdvert jobAdvert) {
		return ResponseEntity.ok(this.jobAdvertService.save(jobAdvert));
	}
	
	@GetMapping(path = "/getall-active")
	public ResponseEntity<?> getAllActive() {
		return ResponseEntity.ok(this.jobAdvertService.findByIsActive(true));
	}
	
	@GetMapping(path = "/getall-active-order-by-createddate-asc")
	public ResponseEntity<?> getAllActiveOrderByCreatedDateAsc() {
		return ResponseEntity.ok(this.jobAdvertService.findByIsActiveOrderByCreatedDateAsc(true));
	}
	
	@GetMapping(path = "/getall-active-order-by-createddate-desc")
	public ResponseEntity<?> getAllActiveOrderByCreatedDateDesc() {
		return ResponseEntity.ok(this.jobAdvertService.findByIsActiveOrderByCreatedDateDesc(true));
	}
	
	@GetMapping(path = "getall-active-by-employer-id/{employerId}")
	public ResponseEntity<?> getAllActiveByEmployer(@PathVariable("employerId") Integer employerId) {
		return ResponseEntity.ok(this.jobAdvertService.findByIsActiveAndEmployerId(true, employerId));
	}
	
	@PostMapping(path = "change-active-status")
	public ResponseEntity<?> changeActiveStatusOfJobAdvert(@RequestParam("jobAdvertId") Integer jobAdvertid,
												@RequestParam("employerId") Integer employerId) {
		return ResponseEntity.ok(this.jobAdvertService.changeIsActiveStatus(jobAdvertid, employerId));
	}
}
