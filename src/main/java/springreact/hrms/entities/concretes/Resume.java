package springreact.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone="Europe/Istanbul")
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "photo_id")
	private Photo photo;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	@OrderBy(value = "endDate desc")
	private List<Education> educations;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	@OrderBy(value = "endDate desc")
	private List<JobExperience> jobExperiences;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<Language> languages;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<SocialMediaLink> socialMediaLinks;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<Preface> prefaces;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<Skill> skills;
}
