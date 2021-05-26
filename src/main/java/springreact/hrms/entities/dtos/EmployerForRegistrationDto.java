package springreact.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegistrationDto {

	private String companyName;
	private String webPage;
	private String email;
	private String phone;
	private String password;
	private String passwordForCheck;
}
