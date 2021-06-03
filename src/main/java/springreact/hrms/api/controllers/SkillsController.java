package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.SkillService;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.Skill;

@RestController
@RequestMapping(path = "/api/skills")
public class SkillsController {

	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@PostMapping(path = "/add")
	public Result saveSkill(@RequestBody Skill skill) {
		return this.skillService.save(skill);
	}
	
	@GetMapping(path = "/getall-by-candidate-id/{id}")
	public Result getAllByCandidateId(@RequestParam("id") int id) {
		return this.skillService.findByCandidateId(id, true);
	}
}
