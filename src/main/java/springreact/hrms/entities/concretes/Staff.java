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
@Table(name = "staffs")
@PrimaryKeyJoinColumn(name = "staff_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", 
	"confirmations", "verificationCodes"})
public class Staff extends User {

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name =  "last_name")
	private String lastName;
	
	@OneToMany(mappedBy = "staff")
	private List<StaffConfirmation> confirmations;
	
	public Staff(int id, String email, String password,
				String firstName, String lastName) {
		super(0, email, password, true, null, new Date());
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
