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
@Table(name = "staff_confirmations_employer")
@PrimaryKeyJoinColumn(name = "employer_confirmation_id")
public class StaffConfirmationEmployer extends StaffConfirmation {
	
	@Column(name = "employer_id")
	private int employerId;
	
	public StaffConfirmationEmployer(int id, int staffId, int employerId) {
		super(id, staffId, true, true, new Date());
		this.employerId = employerId;
	}
}
