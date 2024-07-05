package com.Krush_2.Krush2.controller;

import com.Krush_2.Krush2.dto.DiaryDto;
import com.Krush_2.Krush2.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    public ResponseEntity<Void> createDiary(@RequestBody DiaryDto diaryDto) {
        diaryService.createDiary(diaryDto);
        return ResponseEntity.ok().build();
    }
}