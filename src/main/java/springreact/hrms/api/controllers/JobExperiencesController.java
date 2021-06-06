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

import springreact.hrms.business.abstracts.JobExperienceService;
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
	public ResponseEntity<?> saveJobExperience(@RequestBody @Valid JobExperience jobExperience) {
		return ResponseEntity.ok(this.jobExperienceService.save(jobExperience));
	}
	
	@GetMapping(path = "/getall-by-resume-id/{id}")
	public ResponseEntity<?> getAllJobExperiencesByResumeId(@RequestParam("id") int resumeId) {
		return ResponseEntity.ok(this.jobExperienceService.findByResumeId(resumeId, true));
	}
	
	@GetMapping(path = "/getall-by-resume-id-order-by-end-date-desc/{id}")
	public ResponseEntity<?> getAllJobExperiencesByResumeIdOrderByEndDateDesc(@RequestParam("id") int resumeId) {
		return ResponseEntity.ok(this.jobExperienceService.findByResumeIdOrderByEndDateDesc(resumeId, true));
	}
	
}
