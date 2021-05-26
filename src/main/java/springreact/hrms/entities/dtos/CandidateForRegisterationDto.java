package springreact.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateForRegisterationDto {

	private String firstName;
	private String lastName;
	private String identityNumber;
	private String yearOfBirth;
	private String email;
	private String password;
	private String passwordForCheck;
}
