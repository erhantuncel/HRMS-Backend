package springreact.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_adverts")
public class JobAdvert extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_definition", columnDefinition = "TEXT")
	@NotEmpty
	private String jobDefinition;
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@Column(name = "open_position_count")
	private int openPositionCount;
	
	@Column(name = "deadline")
	@JsonFormat(shape = Shape.STRING, pattern = "dd.MM.yyyy")
	@NotNull
	private LocalDate deadline;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	@NotNull
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	@NotNull
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	@NotNull
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "job_type_id")
	@NotNull
	private JobType jobType;
	
	@ManyToOne
	@JoinColumn(name = "work_location_id")
	@NotNull
	private WorkLocation workLocation;
}
