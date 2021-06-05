package springreact.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.EducationService;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.Education;

@RestController
@RequestMapping(path = "/api/educations")
public class EducationsController {
	
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping(path = "/getall-by-resume-id/{id}")
	public Result getAllActiveEducationsByResumeId(@RequestParam("id") int resumeId) {
		return this.educationService.findByResumeId(resumeId, true);
	}
	
	@GetMapping(path = "/getall-by-resume-id-order-by-end-date-desc/{id}")
	public Result getAllEducationsByResumeIdOrderByEndDateDesc(@RequestParam("id") int resumeId) {
		return this.educationService.findByResumeIdOrderByEndDateDesc(resumeId, true);
	}
	
	@PostMapping(path = "/add")
	public Result saveEducation(@RequestBody @Valid Education education) {
		return this.educationService.save(education);
	}

}
