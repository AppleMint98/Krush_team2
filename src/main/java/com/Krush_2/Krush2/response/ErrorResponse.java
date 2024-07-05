package com.Krush_2.Krush2.response;

import com.Krush_2.Krush2.response.status.BaseSatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ErrorResponse implements BaseSatus{

  private HttpStatus errorCode;
  private String errorMessage;

  @Override
  public HttpStatus getStatus() {
    return errorCode;
  }

  @Override
  public String getMessage() {
    return errorMessage;
  }
}
