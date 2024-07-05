package com.Krush_2.Krush2.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class HistoryResponseDto {
    private ResultDto result;

    @Getter
    @Builder
    public static class ResultDto {
        private List<SubGoalDto> content;
        private int dayCompleteGoals;
        private int dayGoals;
        private int entireGoals;
    }
}