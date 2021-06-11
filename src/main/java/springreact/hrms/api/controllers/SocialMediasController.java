package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.SocialMediaService;

@RestController
@RequestMapping(path = "/api/social-medias")
@CrossOrigin
public class SocialMediasController {

	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}
	
	@GetMapping(path = "/getall")
	public ResponseEntity<?> findAllSocialMedias() {
		return ResponseEntity.ok(this.socialMediaService.findAll());
	}
	
	@GetMapping(path = "/find-by-id/{id}")
	public ResponseEntity<?> findById(@RequestParam(name = "id") int id) {
		return ResponseEntity.ok(this.socialMediaService.findById(id));
	}
	
}
