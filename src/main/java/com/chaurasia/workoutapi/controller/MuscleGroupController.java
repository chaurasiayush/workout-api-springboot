package com.chaurasia.workoutapi.controller;

import com.chaurasia.workoutapi.entity.MuscleGroup;
import com.chaurasia.workoutapi.service.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MuscleGroupController {

    private final MuscleGroupService muscleGroupService;

    @Autowired
    public MuscleGroupController(MuscleGroupService muscleGroupService) {
        this.muscleGroupService = muscleGroupService;
    }

    @GetMapping("/getAllMuscleGroups")
    public List<MuscleGroup> getAllMuscleGroups() {
        return muscleGroupService.getAllMuscleGroups();
    }

    @PostMapping("/addMuscleGroup")
    public ResponseEntity<MuscleGroup> createMuscleGroup(@RequestBody MuscleGroup muscleGroup) {
        MuscleGroup createdMuscleGroup = muscleGroupService.createMuscleGroup(muscleGroup);
        return ResponseEntity.ok(createdMuscleGroup);
    }

    @DeleteMapping("/deleteMuscleGroup/{id}")
    public ResponseEntity<String> deleteMuscleGroup(@PathVariable long id) {
        muscleGroupService.deleteMuscleGroupById(id);
        return ResponseEntity.ok("deleted successfully");
    }
}
