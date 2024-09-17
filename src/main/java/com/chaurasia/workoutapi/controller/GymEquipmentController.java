package com.chaurasia.workoutapi.controller;

import com.chaurasia.workoutapi.entity.GymEquipment;
import com.chaurasia.workoutapi.service.GymEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class GymEquipmentController {

    private final GymEquipmentService gymEquipmentService;

    @Autowired
    public GymEquipmentController(GymEquipmentService gymEquipmentService) {
        this.gymEquipmentService = gymEquipmentService;
    }

    @GetMapping("/gymEquipments")
    public List<GymEquipment> getAllGymEquipments() {
        return gymEquipmentService.getAllGymEquipments();
    }

    @GetMapping("/getEquipment/{id}")
    public ResponseEntity<GymEquipment> getGymEquipmentById(@PathVariable long id) {
        Optional<GymEquipment> equipment = gymEquipmentService.getGymEquipmentById(id);
        if(equipment.isPresent()){
            return ResponseEntity.ok(equipment.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/gymEquipment")
    public ResponseEntity<GymEquipment> postGymEquipment(GymEquipment gymEquipment) {
        try {
            GymEquipment createdGymEquipment =  this.gymEquipmentService.createGymEquipment(gymEquipment);
            return ResponseEntity.ok(createdGymEquipment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/gymEquipment/{id}")
    public ResponseEntity<GymEquipment> updateGymEquipmentById(@PathVariable long id, @RequestBody GymEquipment equipment) {
        try {
            GymEquipment updatedEquipment = gymEquipmentService.updateGymEquipment(id, equipment);
            return ResponseEntity.ok(updatedEquipment);
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/gymEquipment/{id}")
    public ResponseEntity<String> deleteGymEquipmentById(@PathVariable long id) {
        gymEquipmentService.deleteGymEquipmentById(id);
        return ResponseEntity.ok("Item deleted successfully");
    }
}
