package com.Krush_2.Krush2.service;

import com.Krush_2.Krush2.domain.Goal;
import com.Krush_2.Krush2.domain.SubGoal;
import com.Krush_2.Krush2.dto.GoalDto;
import com.Krush_2.Krush2.exception.CustomException;
import com.Krush_2.Krush2.repository.GoalRepository;
import com.Krush_2.Krush2.repository.SubGoalRepository;
import com.Krush_2.Krush2.response.status.ExceptionResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalService {

  private final GoalRepository goalRepository;
  private final SubGoalRepository subGoalRepository;

  public void register(GoalDto request) {
    Goal savedGoal = goalRepository.save(Goal.builder()
      .startAt(request.getStartAt())
      .endAt(request.getEndAt())
      .contents(request.getContents())
      .build());
    request.getSubGoalList().forEach(x -> {
        subGoalRepository.save(SubGoal.builder()
          .goal(savedGoal)
          .contents(x.getContents())
          .emoji(x.getEmoji())
          .build());
      }
    );
  }

  public GoalDto getInfo(long goalId) {
    Goal goal = goalRepository.findById(goalId)
      .orElseThrow(() -> new CustomException(ExceptionResponseStatus.GOAL_NOT_FOUND));
    List<SubGoal> subGoalList = subGoalRepository.findAllByGoal(goal);
    return GoalDto.from(goal, subGoalList);
  }
}
