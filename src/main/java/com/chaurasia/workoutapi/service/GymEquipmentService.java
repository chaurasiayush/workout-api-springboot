package com.chaurasia.workoutapi.service;

import com.chaurasia.workoutapi.entity.GymEquipment;
import com.chaurasia.workoutapi.repository.GymEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymEquipmentService {

    private final GymEquipmentRepository gymEquipmentRepository;

    @Autowired
    public GymEquipmentService(GymEquipmentRepository gymEquipmentRepository) {
        this.gymEquipmentRepository = gymEquipmentRepository;
    }

    public List<GymEquipment> getAllGymEquipments() {
        return this.gymEquipmentRepository.findAll();
    }

    public Optional<GymEquipment> getGymEquipmentById(long id) {
        return this.gymEquipmentRepository.findById(id);
    }

    public GymEquipment createGymEquipment(GymEquipment gymEquipment) {
        return this.gymEquipmentRepository.save(gymEquipment);
    }

    public GymEquipment updateGymEquipment(long id, GymEquipment gymEquipment) {
        Optional<GymEquipment> existingGymEquipment = this.gymEquipmentRepository.findById(id);
        if(existingGymEquipment.isPresent()) {
            GymEquipment equipment = existingGymEquipment.get();
            equipment.setName(gymEquipment.getName());
            equipment.setDescription(gymEquipment.getDescription());
            return this.gymEquipmentRepository.save(equipment);
        } else {
            throw new RuntimeException("Gym equipment not found");
        }
    }

    public void deleteGymEquipmentById(long id) {
        gymEquipmentRepository.deleteById(id);
    }
}
