package springreact.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "employer_id")
public class Employer extends User {

	@Column(name = "company_name")
	@NotEmpty
	private String companyName;
	
	@Column(name = "web_page")
	@NotEmpty
	private String webPage;
	
	@Column(name = "phone")
	@NotEmpty
	@Size(min = 10, max=10)
	private String phone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<StaffConfirmationEmployer> staffConfirmations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
	public Employer(int id, String email, String password, 
			String companyName, String webPage, String phone) {
		super(id, email, password, null);
		this.companyName = companyName;
		this.webPage = webPage;
		this.phone = phone;
	}
}
