package com.chaurasia.workoutapi.controller;

import com.chaurasia.workoutapi.entity.Exercise;
import com.chaurasia.workoutapi.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class ExerciseController {

    private ExerciseService exerciseService;

    // @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/getAllExercises")
    public List<Exercise> getAllExercise() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/getExerciseById/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable long id) {
        Optional<Exercise> exercise = exerciseService.getExerciseById(id);
        if(exercise.isPresent()){
            return ResponseEntity.ok(exercise.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addExercise")
    public ResponseEntity<String> addExercise(@RequestBody Exercise exercise) {
        exerciseService.addExercise(exercise);
        return ResponseEntity.ok("Item created successfully");
    }

    @DeleteMapping("/deleteExerciseById/{id}")
    public ResponseEntity<String> deleteExerciseById(@PathVariable long id){
        try {
            exerciseService.deleteExerciseById(id);
            return ResponseEntity.ok("Item deleted successfully");
        } catch (Error e) {
            return ResponseEntity.notFound().build();
        }
    }
}
