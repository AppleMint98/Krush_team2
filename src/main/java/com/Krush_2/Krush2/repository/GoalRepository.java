package com.Krush_2.Krush2.repository;

import com.Krush_2.Krush2.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal, Long> {

  Optional<Goal> findById(long goalId);

  boolean existsByContents(String contents);

  List<Goal> findByEndAtBefore(LocalDate date);
}
