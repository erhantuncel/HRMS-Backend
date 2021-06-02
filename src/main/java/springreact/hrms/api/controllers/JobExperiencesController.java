package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.JobExperienceService;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping(path = "/api/job-experinces")
public class JobExperiencesController {

	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}

	@PostMapping(path = "/add")
	public Result saveJobExperience(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.save(jobExperience);
	}
	
	@GetMapping(path = "/getall-by-candidate-id/{candidateId}")
	public Result getAllJobExperiencesByCandidateId(@RequestParam("candidateId") int candidateId) {
		return this.jobExperienceService.findByCandidateId(candidateId, true);
	}
	
	@GetMapping(path = "/getall-by-candidate-id-order-by-end-date-desc/{candidateId}")
	public Result getAllEducationsByCandidateIdOrderByEndDateDesc(@RequestParam("candidateId") int candidateId) {
		return this.jobExperienceService.findByCandidateIdOrderByEndDateDesc(candidateId, true);
	}
	
}
