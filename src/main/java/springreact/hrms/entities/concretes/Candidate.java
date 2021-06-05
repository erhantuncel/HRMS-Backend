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
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "candidate_id")
public class Candidate extends User {

	@Column(name = "identity_number")
	@NotEmpty
	@Size(min = 11, max = 11)
	private String identityNumber;
	
	@Column(name = "first_name")
	@NotEmpty
	@Size(min = 2)
	private String firstName;
	
	@Column(name = "last_name")
	@NotEmpty
	@Size(min = 2)
	private String lastName;
	
	@Column(name = "year_of_birth")
	@NotEmpty
	@Size(min = 4, max = 4)
	private String yearOfBirth;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Resume> resumes;
	
	
	public Candidate(int id, String identityNumber, String firstName, 
			String lastName, String email, String yearOfBirth, String password) {
		super(id, email, password, null);
		this.identityNumber = identityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
	}
}
