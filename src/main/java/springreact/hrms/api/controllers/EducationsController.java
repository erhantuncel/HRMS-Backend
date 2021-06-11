package springreact.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.EducationService;
import springreact.hrms.entities.concretes.Education;

@RestController
@RequestMapping(path = "/api/educations")
@CrossOrigin
public class EducationsController {
	
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping(path = "/getall-by-resume-id/{id}")
	public ResponseEntity<?> getAllActiveEducationsByResumeId(@RequestParam("id") int resumeId) {
		return ResponseEntity.ok(this.educationService.findByResumeId(resumeId, true));
	}
	
	@GetMapping(path = "/getall-by-resume-id-order-by-end-date-desc/{id}")
	public ResponseEntity<?> getAllEducationsByResumeIdOrderByEndDateDesc(@RequestParam("id") int resumeId) {
		return ResponseEntity.ok(this.educationService.findByResumeIdOrderByEndDateDesc(resumeId, true));
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<?> saveEducation(@RequestBody @Valid Education education) {
		return ResponseEntity.ok(this.educationService.save(education));
	}

}
