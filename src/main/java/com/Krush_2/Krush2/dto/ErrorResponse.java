package com.Krush_2.Krush2.dto;

import com.Krush_2.Krush2.response.ExceptionResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

  private ExceptionResponseStatus errorCode;
  private String errorMessage;
}
