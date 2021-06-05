package springreact.hrms.api.controllers;

import javax.validation.Valid;

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
	public Result saveSocialMediaLink(@RequestBody @Valid SocialMediaLink socialMediaLink) {
		return this.socialMediaLinkService.save(socialMediaLink);
	}
	
	@GetMapping(path = "/getall-by-resume-id/{id}")
	public Result getAllByResumeId(@RequestParam("id") int resumeId) {
		return this.socialMediaLinkService.findByResumeId(resumeId, true);
	}
	
}
