package com.chaurasia.workoutapi.service;

import com.chaurasia.workoutapi.entity.MuscleGroup;
import com.chaurasia.workoutapi.repository.MuscleGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuscleGroupService {

    private final MuscleGroupRepository muscleGroupRepository;

    @Autowired
    public MuscleGroupService(MuscleGroupRepository muscleGroupRepository) {
        this.muscleGroupRepository = muscleGroupRepository;
    }

    public MuscleGroup createMuscleGroup(MuscleGroup muscleGroup) {
        return muscleGroupRepository.save(muscleGroup);
    }

    public List<MuscleGroup> getAllMuscleGroups() {
        return muscleGroupRepository.findAll();
    }

    public void deleteMuscleGroupById(long id) {
        muscleGroupRepository.deleteById(id);
    }
}
