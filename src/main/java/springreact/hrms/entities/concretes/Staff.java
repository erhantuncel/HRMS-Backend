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
@Table(name = "staffs")
@PrimaryKeyJoinColumn(name = "staff_id")
public class Staff extends User {

	@Column(name = "first_name")
	@NotEmpty
	@Size(min = 2)
	private String firstName;
	
	@Column(name =  "last_name")
	@NotEmpty
	@Size(min = 2)
	private String lastName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "staff")
	private List<StaffConfirmation> confirmations;
	
	public Staff(int id, String email, String password,
				String firstName, String lastName) {
		super(id, email, password, null);
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
