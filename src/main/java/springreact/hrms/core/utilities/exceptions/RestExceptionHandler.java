package springreact.hrms.core.utilities.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import springreact.hrms.core.entities.ApiExceptionResponse;
import springreact.hrms.core.utilities.results.ErrorDataResult;

@RestController
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({Exception.class})
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		Map<String, String> details = new HashMap<String, String>();
		details.put("content", ex.getMessage());
		String type = ex.getClass().getSimpleName();
		String cause = null;
		if(ex.getCause() != null) {			
			cause = ex.getCause().getClass().getSimpleName();
		}
		ApiExceptionResponse exceptionResponse 
		= new ApiExceptionResponse(new Date(), type, cause, details);
		ErrorDataResult<Object> errorDataResult 
			= new ErrorDataResult<Object>(exceptionResponse, "Server Error");
		return new ResponseEntity<Object>(errorDataResult, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> details = new HashMap<String, String>();
		for(FieldError error : ex.getBindingResult().getFieldErrors()) {
			details.put(error.getField(), error.getDefaultMessage());
		}
		String type = ex.getClass().getSimpleName();
		String cause = null;
		if(ex.getCause() != null) {			
			cause = ex.getCause().getClass().getSimpleName();
		}
		ApiExceptionResponse exceptionResponse 
			= new ApiExceptionResponse(new Date(), type, cause, details);
		ErrorDataResult<Object> errorDataResult 
			= new ErrorDataResult<Object>(exceptionResponse, "Validation Error");
		return new ResponseEntity<Object>(errorDataResult, HttpStatus.BAD_REQUEST);
	}	
}
