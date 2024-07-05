package com.Krush_2.Krush2.exception_handler;

import com.Krush_2.Krush2.exception.CustomException;
import com.Krush_2.Krush2.response.ErrorResponse;
import com.Krush_2.Krush2.response.status.ExceptionResponseStatus;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
    log.error("[handleCustomException]", e.getMessage());
    ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode(), e.getMessage());
    return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
  }

  @ExceptionHandler({NoHandlerFoundException.class, TypeMismatchException.class})
  public ResponseEntity<ErrorResponse> handle_BadRequest(Exception e) {
    log.error("[handle_BadRequest]", e);
    ErrorResponse errorResponse = new ErrorResponse(ExceptionResponseStatus.INVALID_REQUEST);
    return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
  }



  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<ErrorResponse> handle_HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
    log.error("[handle_HttpRequestMethodNotSupportedException]", e);
    ErrorResponse errorResponse = new ErrorResponse(ExceptionResponseStatus.INVALID_REQUEST);
    return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> handle_ConstraintViolationException(ConstraintViolationException e) {
    log.error("[handle_ConstraintViolationException]", e);
    ErrorResponse errorResponse = new ErrorResponse(ExceptionResponseStatus.INVALID_REQUEST);
    return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
  }


  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResponse>  handle_RuntimeException(Exception e) {
    log.error("[handle_RuntimeException]", e);
    ErrorResponse errorResponse = new ErrorResponse(ExceptionResponseStatus.SERVER_ERROR);
    return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
  }
}
