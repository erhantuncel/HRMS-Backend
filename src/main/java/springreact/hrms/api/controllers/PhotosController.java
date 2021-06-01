package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springreact.hrms.core.utilities.adapters.imageservices.ImageService;
import springreact.hrms.core.utilities.results.Result;

@RestController
@RequestMapping(path = "/api/photos")
public class PhotosController {

	private ImageService imageService;

	@Autowired
	public PhotosController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping(path = "/add")
	public Result save(@RequestBody MultipartFile file) {
		return this.imageService.save(file);
	}
	
}
