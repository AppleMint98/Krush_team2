package com.Krush_2.Krush2.dto;

import com.Krush_2.Krush2.domain.SubGoal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubGoalDto {
  private String contents;
  private String emoji;

  public static SubGoalDto from(SubGoal subGoal) {
    return SubGoalDto.builder()
      .contents(subGoal.getContents())
      .emoji(subGoal.getEmoji())
      .build();
  }
}

