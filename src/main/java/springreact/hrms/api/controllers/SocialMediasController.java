package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.SocialMediaService;
import springreact.hrms.core.utilities.results.Result;

@RestController
@RequestMapping(path = "/api/social-medias")
public class SocialMediasController {

	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}
	
	@GetMapping(path = "/getall")
	public Result findAllSocialMedias() {
		return this.socialMediaService.findAll();
	}
	
	@GetMapping(path = "/find-by-id/{id}")
	public Result findById(@RequestParam(name = "id") int id) {
		return this.socialMediaService.findById(id);
	}
	
}
