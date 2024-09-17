package com.chaurasia.workoutapi.services;

import com.chaurasia.workoutapi.entity.Exercise;
import com.chaurasia.workoutapi.repository.ExerciseRepository;
import com.chaurasia.workoutapi.service.ExerciseService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExerciseServiceTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private ExerciseService exerciseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllExercises() {
        // Arrange
        Exercise exercise1 = new Exercise();
        Exercise exercise2 = new Exercise();
        List<Exercise> expectedExercises = Arrays.asList(exercise1, exercise2);

        when(exerciseRepository.findAll()).thenReturn(expectedExercises);

        // Act
        List<Exercise> actualExercises = exerciseService.getAllExercises();

        // Assert
        assertEquals(expectedExercises, actualExercises);
        verify(exerciseRepository, times(1)).findAll();
    }

    @Test
    void testGetExerciseById() {
        // Arrange
        Exercise exercise = new Exercise();
        when(exerciseRepository.findById(1L)).thenReturn(Optional.of(exercise));

        // Act
        Optional<Exercise> actualExercise = exerciseService.getExerciseById(1L);

        // Assert
        assertTrue(actualExercise.isPresent());
        assertEquals(exercise, actualExercise.get());
        verify(exerciseRepository, times(1)).findById(1L);
    }

    @Test
    void testGetExerciseByIdNotFound() {
        // Arrange
        when(exerciseRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<Exercise> actualExercise = exerciseService.getExerciseById(1L);

        // Assert
        assertFalse(actualExercise.isPresent());
        verify(exerciseRepository, times(1)).findById(1L);
    }

    @Test
    void testAddExercise() {
        // Arrange
        Exercise exercise = new Exercise();

        // Act
        exerciseService.addExercise(exercise);

        // Assert
        verify(exerciseRepository, times(1)).save(exercise);
    }

    @Test
    void testDeleteExerciseById() {
        // Arrange
        long exerciseId = 1L;

        // Act
        exerciseService.deleteExerciseById(exerciseId);

        // Assert
        verify(exerciseRepository, times(1)).deleteById(exerciseId);
    }
}
