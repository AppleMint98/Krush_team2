package com.Krush_2.Krush2.exception;

import com.Krush_2.Krush2.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
    log.error("{}", e.getMessage());
    ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getStatus(), e.getMessage());
    return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
  }
}
