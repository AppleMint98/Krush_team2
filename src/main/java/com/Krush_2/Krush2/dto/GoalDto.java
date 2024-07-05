package com.Krush_2.Krush2.dto;

import com.Krush_2.Krush2.domain.Goal;
import com.Krush_2.Krush2.domain.SubGoal;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class GoalDto {
    private String contents;
    private LocalDate startAt;
    private LocalDate endAt;
    private List<SubGoalDto> subGoalList;

    public static GoalDto from(Goal goal, List<SubGoal> subGoalList) {
        List<SubGoalDto> subGoalDtoList = new ArrayList<>();
        subGoalList.forEach(x -> {
            subGoalDtoList.add(SubGoalDto.from(x));
        });
        return GoalDto.builder()
                .contents(goal.getContents())
                .startAt(goal.getStartAt())
                .endAt(goal.getEndAt())
                .subGoalList(subGoalDtoList)
                .build();
    }
}
