package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.SocialMediaLinkService;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.SocialMediaLink;

@RestController
@RequestMapping(path = "/api/social-media-links")
public class SocialMediaLinksController {
	
	private SocialMediaLinkService socialMediaLinkService;

	@Autowired
	public SocialMediaLinksController(SocialMediaLinkService socialMediaLinkService) {
		super();
		this.socialMediaLinkService = socialMediaLinkService;
	}
	
	@PostMapping(path = "/add")
	public Result saveSocialMediaLink(@RequestBody SocialMediaLink socialMediaLink) {
		return this.socialMediaLinkService.save(socialMediaLink);
	}
	
	@GetMapping(path = "/getall-by-candidate-id/{id}")
	public Result getAllByCandidateId(@RequestParam("id") int candidateId) {
		return this.socialMediaLinkService.findByCandidateId(candidateId, true);
	}
	
}
