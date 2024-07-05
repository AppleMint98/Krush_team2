package com.Krush_2.Krush2.exception;

import com.Krush_2.Krush2.response.status.BaseSatus;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

  private final BaseSatus errorCode;

  public CustomException(BaseSatus errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
