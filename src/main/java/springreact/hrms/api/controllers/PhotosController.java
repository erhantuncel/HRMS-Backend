package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springreact.hrms.business.abstracts.PhotoService;

@RestController
@RequestMapping(path = "/api/photos")
@CrossOrigin
public class PhotosController {

	PhotoService photoService;
	
	@Autowired
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}

	@GetMapping(path = "getAll")
	public ResponseEntity<?> getAllPhoto() {
		return ResponseEntity.ok(this.photoService.getAll());
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<?> savePhoto(MultipartFile photoFile) {
		return ResponseEntity.ok(this.photoService.save(photoFile));
	}
	
	@GetMapping(path = "/delete/{id}")
	public ResponseEntity<?> deletePhoto(@PathVariable("id") String publicId) {
		return ResponseEntity.ok(this.photoService.delete(publicId));
	}
	
}
