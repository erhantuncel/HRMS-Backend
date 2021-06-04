package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springreact.hrms.business.abstracts.PhotoService;
import springreact.hrms.core.utilities.results.Result;

@RestController
@RequestMapping(path = "/api/photos")
public class PhotosController {

	PhotoService photoService;
	
	@Autowired
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}

	@GetMapping(path = "getAll")
	public Result getAllPhoto() {
		return this.photoService.getAll();
	}
	
	@PostMapping(path = "/save")
	public Result save(MultipartFile photoFile) {
		return this.photoService.save(photoFile);
	}
	
	@GetMapping(path = "/delete/{id}")
	public Result deletePhoto(@RequestParam("id") String publicId) {
		return this.photoService.delete(publicId);
	}
	
}
