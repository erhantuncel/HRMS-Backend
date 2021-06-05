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
public class EmployerForRegistrationDto {

	@NotEmpty
	private String companyName;
	
	@NotEmpty
	private String webPage;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 10, max = 10)
	private String phone;
	
	@NotEmpty
	@Size(min = 6)
	private String password;
	
	@NotEmpty
	@Size(min = 6)
	private String passwordForCheck;
}
