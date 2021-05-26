package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.StaffService;
import springreact.hrms.core.utilities.results.Result;
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
	public Result add(@RequestBody Staff staff) {
		return this.staffService.save(staff);
	}

}