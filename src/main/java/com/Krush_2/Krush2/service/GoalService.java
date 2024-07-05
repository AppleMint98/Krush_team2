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

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalService {

  private final GoalRepository goalRepository;
  private final SubGoalRepository subGoalRepository;

  public void register(GoalDto request) {
    validateGoalContents(request.getContents());
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

  private void validateGoalContents(String contents) {
    if (goalRepository.existsByContents(contents)) {
      throw new CustomException(ExceptionResponseStatus.DUPLICATION_GOAL_CONTENTS);
    }
  }

  public GoalDto getInfo(long goalId) {
    Goal goal = goalRepository.findById(goalId)
      .orElseThrow(() -> new CustomException(ExceptionResponseStatus.GOAL_NOT_FOUND));
    List<SubGoal> subGoalList = subGoalRepository.findAllByGoal(goal);
    return GoalDto.from(goal, subGoalList);
  }

  public List<GoalDto> getPastGoals() {
    List<Goal> pastGoals = goalRepository.findByEndAtBefore(LocalDate.now());
    return pastGoals.stream().map(goal -> {
      List<SubGoal> subGoals = subGoalRepository.findAllByGoal(goal);
      return GoalDto.from(goal, subGoals);
    }).collect(Collectors.toList());
  }
}
