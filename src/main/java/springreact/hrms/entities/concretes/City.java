package springreact.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
@Table(name = "cities")
public class City extends Base {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	@NotEmpty
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private List<JobAdvert> jobAdverts;
}
