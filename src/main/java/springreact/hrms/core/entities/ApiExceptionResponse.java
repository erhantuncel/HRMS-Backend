package springreact.hrms.core.entities;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionResponse {

	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone="Europe/Istanbul")
	private Date date;
	private String type;
	private String cause;
	private Map<String,String> details;
}
