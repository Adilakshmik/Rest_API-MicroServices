package in.ashokit.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExHandler {
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<ExInfo> HandleException(Exception e) {
		ExInfo info=new ExInfo();
		info.setExCode("QJS23");
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDate.now());
			return new ResponseEntity<>(info,HttpStatus.BAD_REQUEST);
		}
}


