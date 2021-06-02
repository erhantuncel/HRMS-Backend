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
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "candidate_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", 
	"educations", "jobExperiences", "languages", "resumes", 
	"verificationCodes", "photos"})
public class Candidate extends User {

	@Column(name = "identity_number")
	private String identityNumber;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "year_of_birth")
	private String yearOfBirth;
	
	@OneToMany(mappedBy = "candidate")
	private List<Photo> photos;
	
	@OneToMany(mappedBy = "candidate")
	private List<Education> educations;
	
	@OneToMany(mappedBy = "candidate")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "candidate")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "candidate")
	private List<Resume> resumes;
	
	public Candidate(int id, String identityNumber, String firstName, 
			String lastName, String email, String yearOfBirth, String password) {
		super(id, email, password, false, null, new Date());
		this.identityNumber = identityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
	}
}
