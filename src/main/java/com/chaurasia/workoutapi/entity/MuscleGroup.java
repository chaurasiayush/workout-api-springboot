package com.chaurasia.workoutapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "muscle_group")

public class MuscleGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(nullable = true)
    private String description;
    
    // getters
    
    public long getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    // setters
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
