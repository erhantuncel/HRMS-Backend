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
@Table(name = "staffs")
@PrimaryKeyJoinColumn(name = "staff_id")
public class Staff extends User {

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name =  "last_name")
	private String lastName;
	
	public Staff(int id, String email, String password,
				String firstName, String lastName) {
		super(0, email, password, true, new Date());
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
