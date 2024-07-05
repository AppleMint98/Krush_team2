package com.Krush_2.Krush2.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DiaryRequest {
  private Long goalId;
  private Long subGoalId;
}
