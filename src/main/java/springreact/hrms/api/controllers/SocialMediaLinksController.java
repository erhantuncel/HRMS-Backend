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

import springreact.hrms.business.abstracts.SocialMediaLinkService;
import springreact.hrms.entities.concretes.SocialMediaLink;

@RestController
@RequestMapping(path = "/api/social-media-links")
@CrossOrigin
public class SocialMediaLinksController {
	
	private SocialMediaLinkService socialMediaLinkService;

	@Autowired
	public SocialMediaLinksController(SocialMediaLinkService socialMediaLinkService) {
		super();
		this.socialMediaLinkService = socialMediaLinkService;
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<?> saveSocialMediaLink(@RequestBody @Valid SocialMediaLink socialMediaLink) {
		return ResponseEntity.ok(this.socialMediaLinkService.save(socialMediaLink));
	}
	
	@GetMapping(path = "/getall-by-resume-id/{id}")
	public ResponseEntity<?> getAllSocialMediaLinksByResumeId(@PathVariable("id") int resumeId) {
		return ResponseEntity.ok(this.socialMediaLinkService.findByResumeId(resumeId, true));
	}
	
}
