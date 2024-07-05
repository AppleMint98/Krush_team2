package com.Krush_2.Krush2.service;

import com.Krush_2.Krush2.domain.Diary;
import com.Krush_2.Krush2.domain.Goal;
import com.Krush_2.Krush2.domain.SubGoal;
import com.Krush_2.Krush2.dto.GoalDto;
import com.Krush_2.Krush2.dto.HistoryResponseDto;
import com.Krush_2.Krush2.dto.SubGoalDto;
import com.Krush_2.Krush2.exception.CustomException;
import com.Krush_2.Krush2.repository.DiaryRepository;
import com.Krush_2.Krush2.repository.GoalRepository;
import com.Krush_2.Krush2.repository.SubGoalRepository;
import com.Krush_2.Krush2.response.status.ExceptionResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalService {

  private final GoalRepository goalRepository;
  private final SubGoalRepository subGoalRepository;
  private final DiaryRepository diaryRepository;
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

  public List<GoalDto> getInProgress() {
    List<Goal> inProgressGoalList = goalRepository.findAllByEndAtAfter(LocalDate.now());
    List<GoalDto> goalDtoList = new ArrayList<>();
    inProgressGoalList.forEach(x -> {
      goalDtoList.add(GoalDto.from(x, subGoalRepository.findAllByGoal(x)));
    });
    return goalDtoList;
  }

  public HistoryResponseDto getHistory(int year, int month, int day) {
    LocalDate date = LocalDate.of(year, month, day);
    List<SubGoal> subGoals = subGoalRepository.findByCreatedAtBetween(date.atStartOfDay(), date.plusDays(1).atStartOfDay());
    List<Diary> diaries = diaryRepository.findByCreatedAtBetween(date.atStartOfDay(), date.plusDays(1).atStartOfDay());

    List<SubGoalDto> subGoalDtos = subGoals.stream()
            .map(SubGoalDto::from)
            .collect(Collectors.toList());

    int entireGoals = (int) subGoalRepository.count();
    int dayGoals = subGoals.size();
    int dayCompleteGoals = diaries.size();

    HistoryResponseDto.ResultDto resultDto = HistoryResponseDto.ResultDto.builder()
            .content(subGoalDtos)
            .dayCompleteGoals(dayCompleteGoals)
            .dayGoals(dayGoals)
            .entireGoals(entireGoals)
            .build();

    return HistoryResponseDto.builder()
            .result(resultDto)
            .build();
  }
}
