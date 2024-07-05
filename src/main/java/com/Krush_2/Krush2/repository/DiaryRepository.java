package com.Krush_2.Krush2.repository;

import com.Krush_2.Krush2.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
