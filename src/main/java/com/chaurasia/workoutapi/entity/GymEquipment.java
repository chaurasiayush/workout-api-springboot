package com.chaurasia.workoutapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "gym_equipment")
public class GymEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setDescription (String desc) {
        this.description = desc;
    }

    // getters

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription () {
        return this.description;
    }
}
