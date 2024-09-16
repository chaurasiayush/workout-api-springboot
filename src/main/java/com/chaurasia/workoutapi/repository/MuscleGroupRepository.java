package com.chaurasia.workoutapi.repository;

import com.chaurasia.workoutapi.entity.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuscleGroupRepository extends JpaRepository <MuscleGroup, Long> {
}
