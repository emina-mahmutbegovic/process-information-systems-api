package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.VrstaEmisije;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.processinformationsystemsapplication.repository.VrstaEmisijeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VrstaEmisijeService {

    private final VrstaEmisijeRepository vrstaEmisijeRepository;

    @Autowired
    public VrstaEmisijeService(VrstaEmisijeRepository vrstaEmisijeRepository) {
        this.vrstaEmisijeRepository = vrstaEmisijeRepository;
    }

    // Create
    public VrstaEmisije createVrstaEmisije(VrstaEmisije vrstaEmisije) {
        return vrstaEmisijeRepository.save(vrstaEmisije);
    }

    // Read
    public List<VrstaEmisije> getAllVrsteEmisije() {
        return vrstaEmisijeRepository.findAll();
    }

    public Optional<VrstaEmisije> getVrstaEmisijeById(String id) {
        return vrstaEmisijeRepository.findById(id);
    }

    // Update
    public Optional<VrstaEmisije> updateVrstaEmisije(String id, VrstaEmisije updatedVrstaEmisije) {
        return vrstaEmisijeRepository.findById(id)
                .map(existingVrstaEmisije -> {
                    existingVrstaEmisije.setNazivVrsteEmisije(updatedVrstaEmisije.getNazivVrsteEmisije());
                    // Add other fields to update as needed
                    return vrstaEmisijeRepository.save(existingVrstaEmisije);
                });
    }

    // Delete
    public void deleteVrstaEmisije(String id) {
        vrstaEmisijeRepository.deleteById(id);
    }
}

