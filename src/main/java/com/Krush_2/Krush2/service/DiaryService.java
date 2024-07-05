package com.Krush_2.Krush2.service;

import com.Krush_2.Krush2.domain.Diary;
import com.Krush_2.Krush2.domain.Member;
import com.Krush_2.Krush2.domain.SubGoal;
import com.Krush_2.Krush2.dto.DiaryDto;
import com.Krush_2.Krush2.exception.CustomException;
import com.Krush_2.Krush2.repository.DiaryRepository;
import com.Krush_2.Krush2.repository.MemberRepository;
import com.Krush_2.Krush2.repository.SubGoalRepository;
import com.Krush_2.Krush2.response.status.ExceptionResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final SubGoalRepository subGoalRepository;
    private final MemberRepository memberRepository;

    public void createDiary(DiaryDto diaryDto) {
        SubGoal subGoal = subGoalRepository.findById(diaryDto.getSubGoalId())
                .orElseThrow(() -> new CustomException(ExceptionResponseStatus.SUBGOAL_NOT_FOUND));
        Member member = memberRepository.findById(diaryDto.getMemberId())
                .orElseThrow(() -> new CustomException(ExceptionResponseStatus.MEMBER_NOT_FOUND));

        Diary diary = Diary.builder()
                .subGoal(subGoal)
                .member(member)
                .memo(diaryDto.getMemo())
                .build();

        diaryRepository.save(diary);
    }
}
