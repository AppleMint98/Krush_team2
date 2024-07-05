package com.Krush_2.Krush2.controller;

import com.Krush_2.Krush2.dto.DiaryDto;
import com.Krush_2.Krush2.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping("/sub-goal/{subGoalId}")
    public ResponseEntity<Void> register(@PathVariable Long subGoalId) {
        diaryService.register(subGoalId);
        return ResponseEntity.ok().build();
    }
}
