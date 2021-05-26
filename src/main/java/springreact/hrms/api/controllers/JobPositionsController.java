package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.JobPositionService;
import springreact.hrms.core.utilities.results.Result;
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
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.save(jobPosition);
	}
	
	@GetMapping("/getall")
	public Result getAll() {
		return this.jobPositionService.getAll();
	}
}
