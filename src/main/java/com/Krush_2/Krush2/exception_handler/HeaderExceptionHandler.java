package com.Krush_2.Krush2.exception_handler;

import com.Krush_2.Krush2.exception.CustomException;
import com.Krush_2.Krush2.exception.header.HeaderBadRequestException;
import com.Krush_2.Krush2.response.ErrorResponse;
import com.Krush_2.Krush2.response.status.ExceptionResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order(1)
@RestControllerAdvice
public class HeaderExceptionHandler {

  @ExceptionHandler(HeaderBadRequestException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(Exception e) {
    log.error("{}", e.getMessage());
    ErrorResponse errorResponse = new ErrorResponse(ExceptionResponseStatus.EMPTY_HEADER, e.getMessage());
    return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
  }
}
