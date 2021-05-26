package springreact.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
	private String companyName;
	
	@Column(name = "web_page")
	private String webPage;
	
	@Column(name = "phone")
	private String phone;
	
	public Employer(int id, String email, String password, 
			String companyName, String webPage, String phone) {
		super(id, email, password, false, new Date());
		this.companyName = companyName;
		this.webPage = webPage;
		this.phone = phone;
	}
	
	
}
