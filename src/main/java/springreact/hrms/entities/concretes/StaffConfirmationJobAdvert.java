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
@Table(name = "staff_confirmations_job_advert")
@PrimaryKeyJoinColumn(name = "job_advert_confirmation_id")
public class StaffConfirmationJobAdvert extends StaffConfirmation {

	@ManyToOne
	@JoinColumn(name = "job_advert_id")
	private JobAdvert jobAdvert;

	public StaffConfirmationJobAdvert(int id, Staff staff, JobAdvert jobAdvert) {
		super(id, staff, true);
		this.jobAdvert = jobAdvert;
	}
}
