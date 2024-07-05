package com.Krush_2.Krush2.controller;

import com.Krush_2.Krush2.dto.GoalDto;
import com.Krush_2.Krush2.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goal")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody GoalDto request) {
        goalService.register(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<GoalDto> getInfo(@RequestParam Long goalId) {
        return ResponseEntity.ok(goalService.getInfo(goalId));
    }

    @GetMapping("/complete")
    public ResponseEntity<List<GoalDto>> getPastGoals() {
        return ResponseEntity.ok(goalService.getPastGoals());
    }

    @GetMapping("/in-progress")
    public ResponseEntity<List<GoalDto>> getInProgress() {
        return ResponseEntity.ok(goalService.getInProgress());
    }
}
