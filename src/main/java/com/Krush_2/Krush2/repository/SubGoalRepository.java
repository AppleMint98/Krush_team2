package com.Krush_2.Krush2.repository;

import com.Krush_2.Krush2.domain.Goal;
import com.Krush_2.Krush2.domain.SubGoal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubGoalRepository extends JpaRepository<SubGoal, Long> {
  List<SubGoal> findAllByGoal(Goal goal);
}
