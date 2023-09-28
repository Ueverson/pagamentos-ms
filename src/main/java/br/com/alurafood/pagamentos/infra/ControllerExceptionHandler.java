package br.com.alurafood.pagamentos.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alurafood.pagamentos.dto.ExceptionDTO;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	private ExceptionDTO exception;
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionDTO> handleInsufficientBalanceException(ConstraintViolationException e) {
	
		String mensagemDesejada = e.getConstraintViolations().stream()
	            .map(violation ->  violation.getMessage() + " " + violation.getPropertyPath())
	            .findFirst()
	            .orElse("Nenhuma violação encontrada.");
		
		exception = new ExceptionDTO(mensagemDesejada);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
	}
}
