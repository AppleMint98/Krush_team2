package com.Krush_2.Krush2.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDto {
  private String loginId;
  private String password;
}
