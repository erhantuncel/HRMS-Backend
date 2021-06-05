package springreact.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "educations")
public class Education extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	@NotEmpty
	private String schoolName;
	
	@Column(name = "department")
	@NotEmpty
	private String department;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = Shape.STRING, pattern = "dd.MM.yyyy", timezone="Europe/Istanbul")
	@NotNull
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = Shape.STRING, pattern = "dd.MM.yyyy", timezone="Europe/Istanbul")
	private Date endDate;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
