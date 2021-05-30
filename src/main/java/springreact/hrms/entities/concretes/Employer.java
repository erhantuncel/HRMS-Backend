package springreact.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", 
	"jobAdverts", "staffConfirmations", "verificationCodes"})
public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_page")
	private String webPage;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "employer")
	private List<StaffConfirmationEmployer> staffConfirmations;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
	public Employer(int id, String email, String password, 
			String companyName, String webPage, String phone) {
		super(id, email, password, false, null, new Date());
		this.companyName = companyName;
		this.webPage = webPage;
		this.phone = phone;
	}
}
