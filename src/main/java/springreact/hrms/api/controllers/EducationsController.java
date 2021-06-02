package springreact.hrms.api.controllers;

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
	
	@GetMapping(path = "/getall-by-candidate-id/{candidateId}")
	public Result getAllActiveEducationsByCandidateId(@RequestParam("candidateId") int candidateId) {
		return this.educationService.findByCandidateId(candidateId, true);
	}
	
	@GetMapping(path = "/getall-by-candidate-id-order-by-end-date-desc/{candidateId}")
	public Result getAllEducationsByCandidateIdOrderByEndDateDesc(@RequestParam("candidateId") int candidateId) {
		return this.educationService.findByCandidateIdOrderByEndDateDesc(candidateId, true);
	}
	
	@PostMapping(path = "/add")
	public Result saveEducation(@RequestBody Education education) {
		return this.educationService.save(education);
	}

}
