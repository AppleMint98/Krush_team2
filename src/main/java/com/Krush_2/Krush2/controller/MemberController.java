package com.Krush_2.Krush2.controller;

import com.Krush_2.Krush2.dto.MemberDto;
import com.Krush_2.Krush2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/sign-up")
  public ResponseEntity<Void> sighUp(@RequestBody MemberDto memberDto) {
    memberService.signUp(memberDto);
    return ResponseEntity.ok().build();
  }
}
