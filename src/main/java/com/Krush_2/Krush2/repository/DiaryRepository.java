package com.Krush_2.Krush2.repository;

import com.Krush_2.Krush2.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}
