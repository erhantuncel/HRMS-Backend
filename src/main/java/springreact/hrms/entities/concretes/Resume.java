package springreact.hrms.entities.concretes;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resumes")
public class Resume extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	@NotNull
	private Candidate candidate;
	
	@Column(name = "name")
	@NotEmpty
	private String name;
	
	@Column(name = "preface", columnDefinition = "TEXT")
	@NotEmpty
	private String preface;
	
	@ManyToOne
	@JoinColumn(name = "photo_id")
	@NotNull
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
	private List<Skill> skills;
}
