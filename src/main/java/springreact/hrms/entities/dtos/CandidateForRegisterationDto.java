package springreact.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateForRegisterationDto {

	@NotEmpty
	@Size(min = 2)
	private String firstName;
	
	@NotEmpty
	@Size(min = 2)
	private String lastName;
	
	@NotEmpty
	@Size(min = 11, max = 11)
	private String identityNumber;
	
	@NotEmpty
	@Size(min = 4, max = 4)
	private String yearOfBirth;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 6)
	private String password;
	
	@NotEmpty
	@Size(min = 6)
	private String passwordForCheck;
}
