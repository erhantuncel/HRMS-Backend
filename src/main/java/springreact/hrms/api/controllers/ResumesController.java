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
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.ResumeService;
import springreact.hrms.entities.concretes.Resume;

@RestController
@RequestMapping(path = "/api/resumes")
@CrossOrigin
public class ResumesController {
	
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<?> saveResume(@RequestBody @Valid Resume resume) {
		return ResponseEntity.ok(this.resumeService.save(resume));
	}
	
	@GetMapping(path = "/getall-by-candidate-id/{id}")
	public ResponseEntity<?> getActiveResumeByCandidateId(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(this.resumeService.findByCandidateId(id, true));
	}
}
