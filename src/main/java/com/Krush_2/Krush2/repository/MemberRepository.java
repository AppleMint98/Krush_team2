package com.Krush_2.Krush2.repository;

import com.Krush_2.Krush2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
  boolean existsByLoginId(String loginId);
}
