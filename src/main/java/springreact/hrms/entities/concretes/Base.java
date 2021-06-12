package springreact.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
public class Base {

	@JsonIgnore
	@Column(name = "is_active")
	private boolean isActive = true;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Istanbul")
	@Column(name = "created_date")
	private Date createdDate = new Date();
}
