package com.Krush_2.Krush2.service;

import com.Krush_2.Krush2.domain.Diary;
import com.Krush_2.Krush2.domain.Goal;
import com.Krush_2.Krush2.domain.SubGoal;
import com.Krush_2.Krush2.exception.CustomException;
import com.Krush_2.Krush2.repository.DiaryRepository;
import com.Krush_2.Krush2.repository.GoalRepository;
import com.Krush_2.Krush2.repository.SubGoalRepository;
import com.Krush_2.Krush2.response.status.ExceptionResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiaryService {

  private final GoalRepository goalRepository;
  private final SubGoalRepository subGoalRepository;
  private final DiaryRepository diaryRepository;


  public void register(long subGoalId) {
    SubGoal subGoal = validateSubGoalId(subGoalId);
    Optional<Diary> diary = diaryRepository.findBySubGoal(subGoal);
    if (diary.isPresent()) {
      diary.get().changeStatusToInActive();
      diaryRepository.save(diary.get());
      return;
    }
    validateGoalId(subGoal.getGoal());
    diaryRepository.save(Diary.builder()
      .subGoal(subGoal)
      .build());
  }

  public void validateGoalId(Goal goal) {
    if (!goalRepository.existsById(goal.getId())) {
      throw new CustomException(ExceptionResponseStatus.GOAL_NOT_FOUND);
    }
  }

  public SubGoal validateSubGoalId(long subGoalId) {
    return subGoalRepository.findById(subGoalId)
      .orElseThrow(() -> new CustomException(ExceptionResponseStatus.SUB_GOAL_NOT_FOUND));
  }
}
