package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.WorkLocationService;

@RestController
@RequestMapping(path = "/api/work-locations")
@CrossOrigin
public class WorkLocationsController {

	private WorkLocationService workTypeService;

	@Autowired
	public WorkLocationsController(WorkLocationService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@GetMapping(path = "getall")
	public ResponseEntity<?> getAllWorkLocations() {
		return ResponseEntity.ok(this.workTypeService.getAll());
	}
	
}
