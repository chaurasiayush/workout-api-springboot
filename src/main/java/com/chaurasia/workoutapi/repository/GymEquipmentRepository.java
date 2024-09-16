package com.chaurasia.workoutapi.repository;

import com.chaurasia.workoutapi.entity.GymEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymEquipmentRepository extends JpaRepository <GymEquipment, Long>{

}
