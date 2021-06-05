package springreact.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.JobAdvertService;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping(path = "/api/jobadverts")
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping(path = "/add")
	public Result add(@RequestBody @Valid JobAdvert jobAdvert) {
		return this.jobAdvertService.save(jobAdvert);
	}
	
	@GetMapping(path = "/getall-active")
	public Result getAllActive() {
		return this.jobAdvertService.findByIsActive(true);
	}
	
	@GetMapping(path = "/getall-active-order-by-createddate-asc")
	public Result getAllActiveOrderByCreatedDateAsc() {
		return this.jobAdvertService.findByIsActiveOrderByCreatedDateAsc(true);
	}
	
	@GetMapping(path = "/getall-active-order-by-createddate-desc")
	public Result getAllActiveOrderByCreatedDateDesc() {
		return this.jobAdvertService.findByIsActiveOrderByCreatedDateDesc(true);
	}
	
	@GetMapping(path = "getall-active-by-employer-id/{employerId}")
	public Result getAllActiveByEmployer(@RequestParam("employerId") Integer employerId) {
		return this.jobAdvertService.findByIsActiveAndEmployerId(true, employerId);
	}
	
	@PostMapping(path = "change-active-status")
	public Result changeActiveStatusOfJobAdvert(@RequestParam("jobAdvertId") Integer jobAdvertid,
												@RequestParam("employerId") Integer employerId) {
		return this.jobAdvertService.changeIsActiveStatus(jobAdvertid, employerId);
	}
}
