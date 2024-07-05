package com.Krush_2.Krush2.response;

import com.Krush_2.Krush2.response.status.BaseSatus;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonPropertyOrder({"errorCode", "errorMessage"})
public class ErrorResponse implements BaseSatus{

  private HttpStatus errorCode;
  private String errorMessage;

  public ErrorResponse(BaseSatus errorCode, String errorMessage) {
    this.errorCode = errorCode.getStatus();
    this.errorMessage = errorMessage;
  }
  public ErrorResponse(BaseSatus errorCode) {
    this.errorCode = errorCode.getStatus();
    this.errorMessage = errorCode.getMessage();
  }

  @Override
  public HttpStatus getStatus() {
    return errorCode;
  }

  @Override
  public String getMessage() {
    return errorMessage;
  }
}
