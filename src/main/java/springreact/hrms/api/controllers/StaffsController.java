package springreact.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.StaffService;
import springreact.hrms.entities.concretes.Staff;

@RestController
@RequestMapping(path = "/api/staffs")
public class StaffsController {

	private StaffService staffService;

	@Autowired
	public StaffsController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}

	@PostMapping(path = "/add")
	public ResponseEntity<?> addStaff(@RequestBody @Valid Staff staff) {
		return ResponseEntity.ok(this.staffService.save(staff));
	}

}
