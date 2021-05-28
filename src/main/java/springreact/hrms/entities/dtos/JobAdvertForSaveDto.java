package springreact.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertForSaveDto {

	private int id;
	private int employerId;
	private int jobPositionId;
	private int cityId;
	private String jobDefinition;
	private double minSalary;
	private double maxSalary;
	private int openPositionCount;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd.MM.yyyy")
	private LocalDate deadline;
}
