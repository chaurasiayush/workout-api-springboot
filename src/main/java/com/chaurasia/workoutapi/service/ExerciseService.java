package com.chaurasia.workoutapi.service;

import com.chaurasia.workoutapi.entity.Exercise;
import com.chaurasia.workoutapi.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Optional<Exercise> getExerciseById(long id) {
        return exerciseRepository.findById(id);
    }

    public void addExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    public void deleteExerciseById(long id) {
        exerciseRepository.deleteById(id);
    }
}
