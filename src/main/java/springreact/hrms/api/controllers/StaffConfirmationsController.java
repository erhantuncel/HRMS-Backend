package springreact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.StaffConfirmationJobAdvertService;

@RestController
@RequestMapping(path = "/api/staff-confirmations")
@CrossOrigin
public class StaffConfirmationsController {

	private StaffConfirmationJobAdvertService staffConfirmationJobAdvertService;

	@Autowired
	public StaffConfirmationsController(StaffConfirmationJobAdvertService staffConfirmationJobAdvertService) {
		super();
		this.staffConfirmationJobAdvertService = staffConfirmationJobAdvertService;
	}

	@GetMapping(path = "confirm-jobadvert/{jobAdvertId}/{staffId}")
	public ResponseEntity<?> confirmJobAdvert(@PathVariable("jobAdvertId") Integer jobAdvertId,
												@PathVariable("staffId") Integer staffId) {
		return ResponseEntity.ok(
				this.staffConfirmationJobAdvertService.confirmJobAdvert(jobAdvertId, staffId));
	}	
}
