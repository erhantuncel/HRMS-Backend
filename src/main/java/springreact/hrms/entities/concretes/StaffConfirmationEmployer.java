package springreact.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "staff_confirmations_employer")
@PrimaryKeyJoinColumn(name = "employer_confirmation_id")
public class StaffConfirmationEmployer extends StaffConfirmation {
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	public StaffConfirmationEmployer(int id, Staff staff, Employer employer) {
		super(id, staff, true);
		this.employer = employer;
	}
}
