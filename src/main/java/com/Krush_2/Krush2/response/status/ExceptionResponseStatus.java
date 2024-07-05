package com.Krush_2.Krush2.response.status;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ExceptionResponseStatus implements BaseSatus {

  // global
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 문제가 발생했습니다."),
  INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
  METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 HTTP Method 입니다."),
  SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다."),
  //Header
  EMPTY_HEADER(HttpStatus.BAD_REQUEST, "헤더의 유저 id가 포함되어 있지 않습니다."),
  INVALID_HEADER(HttpStatus.BAD_REQUEST, "헤더의 유저 id가 올바르지 않습니다."),


  // member
  DUPLICATION_LOGIN_ID(HttpStatus.BAD_REQUEST, "이미 존재하는 아이디 입니다."),

  // goal
  GOAL_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 목표 입니다."),
  SUBGOAL_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 하위목표 입니다."),
  MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 멤버 입니다."),

  DUPLICATION_GOAL_CONTENTS(HttpStatus.BAD_REQUEST, "이미 존재하는 목표입니다.");

  private final HttpStatus status;
  private final String message;

  public HttpStatus getStatus() {
    return status;
  }
  public String getMessage() {
    return message;
  }
}
