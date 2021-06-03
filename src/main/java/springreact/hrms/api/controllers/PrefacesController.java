package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.PrefaceService;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.Preface;

@RestController
@RequestMapping(path = "/api/prefaces")
public class PrefacesController {

	private PrefaceService prefaceService;

	@Autowired
	public PrefacesController(PrefaceService prefaceService) {
		super();
		this.prefaceService = prefaceService;
	}
	
	@PostMapping(path = "/add")
	public Result savePreface(@RequestBody Preface preface) {
		return this.prefaceService.save(preface);
	}
	
	@GetMapping(path = "/getall-by-candidate-id/{id}")
	public Result getAllPrefacesByCandidateId(@RequestParam(name = "id") int id) {
		return this.prefaceService.findByCandidateId(id, true);
	}
	
}
