package com.Krush_2.Krush2.repository;

import com.Krush_2.Krush2.domain.Diary;
import com.Krush_2.Krush2.domain.SubGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    Optional<Diary> findBySubGoal(SubGoal subGoal);
}
