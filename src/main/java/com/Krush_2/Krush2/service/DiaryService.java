package com.Krush_2.Krush2.service;

import com.Krush_2.Krush2.domain.Diary;
import com.Krush_2.Krush2.domain.Goal;
import com.Krush_2.Krush2.domain.SubGoal;
import com.Krush_2.Krush2.dto.DiaryRequest;
import com.Krush_2.Krush2.exception.CustomException;
import com.Krush_2.Krush2.repository.DiaryRepository;
import com.Krush_2.Krush2.repository.GoalRepository;
import com.Krush_2.Krush2.repository.SubGoalRepository;
import com.Krush_2.Krush2.response.status.ExceptionResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiaryService {

  private final GoalRepository goalRepository;
  private final SubGoalRepository subGoalRepository;
  private final DiaryRepository diaryRepository;


  public void register(long subGoalId) {
    Optional<SubGoal> subGoal = subGoalRepository.findById(subGoalId);
    if (subGoal.isPresent()) {
      SubGoal editedSubGoal = subGoal.get();
      editedSubGoal.setStatus("InActive");
      subGoalRepository.save(editedSubGoal);
      System.out.println(editedSubGoal.toString());
      return;
    }
    validateGoalId(subGoal.get().getGoal());
    diaryRepository.save(Diary.builder()
      .subGoal(subGoal.get())
      .build());
  }

  public void validateGoalId(Goal goal) {
    if (!goalRepository.existsById(goal.getId())) {
      throw new CustomException(ExceptionResponseStatus.GOAL_NOT_FOUND);
    }
  }
}
