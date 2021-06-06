package springreact.hrms.core.utilities.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import springreact.hrms.core.entities.ApiExceptionResponse;

@RestController
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({Exception.class})
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		String message = "Server Error";
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());
		String type = ex.getClass().getSimpleName();
		String cause = null;
		if(ex.getCause() != null) {			
			cause = ex.getCause().getClass().getSimpleName();
		}
		ApiExceptionResponse exceptionResponse 
		= new ApiExceptionResponse(new Date(), message, type, cause, details);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = "Validation Error";
		List<String> details = new ArrayList<>();
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		String type = ex.getClass().getSimpleName();
		String cause = null;
		if(ex.getCause() != null) {			
			cause = ex.getCause().getClass().getSimpleName();
		}
		ApiExceptionResponse exceptionResponse 
			= new ApiExceptionResponse(new Date(), message, type, cause, details);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}	
}
