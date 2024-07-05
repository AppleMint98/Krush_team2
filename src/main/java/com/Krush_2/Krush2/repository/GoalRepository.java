package com.Krush_2.Krush2.repository;

import com.Krush_2.Krush2.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal, Long> {
  Optional<Goal> findById(long goalId);
}
