package com.ame.ame.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ame.ame.exception.PizzaAlreadyExistException;
import com.ame.ame.exception.PizzaAlreadyExistExceptionDetails;
import com.ame.ame.exception.ValidationExceptionDetails;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(PizzaAlreadyExistException.class)
	public ResponseEntity<PizzaAlreadyExistExceptionDetails> handlerPizzaAlreadyExistsException(
			PizzaAlreadyExistException exception) {
		return new ResponseEntity<>(
				PizzaAlreadyExistExceptionDetails.builder()
						.timestamp(LocalDateTime.now())
						.status(HttpStatus.BAD_REQUEST.value())
						.title("Invalid Name")
						.details(exception.getMessage())
						.developerMessage(exception.getClass().getName())
						.build(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidEntity(
			MethodArgumentNotValidException exception) {

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
		String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.joining(", "));

		return new ResponseEntity<>(
				ValidationExceptionDetails.builder()
						.timestamp(LocalDateTime.now())
						.details("Check's the field(s) error")
						.developerMessage(exception.getClass().getName())
						.fields(fields)
						.fieldsMessage(fieldsMessage)
						.title("Invalid fields Exception. Check the documentation")
						.status(HttpStatus.BAD_REQUEST.value())
						.build(),
				HttpStatus.BAD_REQUEST);
	}

}
