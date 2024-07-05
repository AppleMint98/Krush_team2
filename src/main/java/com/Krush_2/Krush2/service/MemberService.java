package com.Krush_2.Krush2.service;

import com.Krush_2.Krush2.domain.Member;
import com.Krush_2.Krush2.dto.MemberDto;
import com.Krush_2.Krush2.exception.CustomException;
import com.Krush_2.Krush2.response.ExceptionResponseStatus;
import com.Krush_2.Krush2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public void signUp(MemberDto memberDto) {
    validateLoginId(memberDto.getLoginId());

    memberRepository.save(Member.builder()
      .loginId(memberDto.getLoginId())
      .password(memberDto.getPassword())
      .build());
  }

  public void validateLoginId(String loginId) {
    if (memberRepository.existsByLoginId(loginId)) {
      throw new CustomException(ExceptionResponseStatus.DUPLICATION_LOGIN_ID);
    }
  }

  public boolean existLoginId(String loginId) {
    return memberRepository.existsByLoginId(loginId);
  }
}
