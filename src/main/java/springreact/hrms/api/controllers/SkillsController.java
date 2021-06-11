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

import springreact.hrms.business.abstracts.SkillService;
import springreact.hrms.entities.concretes.Skill;

@RestController
@RequestMapping(path = "/api/skills")
@CrossOrigin
public class SkillsController {

	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<?> saveSkill(@RequestBody @Valid Skill skill) {
		return ResponseEntity.ok(this.skillService.save(skill));
	}
	
	@GetMapping(path = "/getall-by-resume-id/{id}")
	public ResponseEntity<?> getAllSkillsByResumeId(@RequestParam("id") int id) {
		return ResponseEntity.ok(this.skillService.findByResumeId(id, true));
	}
}
