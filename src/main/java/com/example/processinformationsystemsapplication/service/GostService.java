package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.Gost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.processinformationsystemsapplication.repository.GostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GostService {

    private final GostRepository gostRepository;

    @Autowired
    public GostService(GostRepository gostRepository) {
        this.gostRepository = gostRepository;
    }

    // Create
    public Gost createGost(Gost gost) {
        return gostRepository.save(gost);
    }

    // Read All
    public List<Gost> getAllGosti() {
        return gostRepository.findAll();
    }

    // Read by ID
    public Optional<Gost> getGostById(String id) {
        return gostRepository.findById(id);
    }

    // Update by ID
    public Optional<Gost> updateGost(String id, Gost updatedGost) {
        return gostRepository.findById(id)
                .map(existingGost -> {
                    existingGost.setImeGosta(updatedGost.getImeGosta());
                    existingGost.setPrezimeGosta(updatedGost.getPrezimeGosta());
                    existingGost.setBiografijaGosta(updatedGost.getBiografijaGosta());
                    existingGost.setKontaktTelefonGosta(updatedGost.getKontaktTelefonGosta());
                    // Add other fields to update as needed
                    return gostRepository.save(existingGost);
                });
    }

    // Delete by ID
    public void deleteGost(String id) {
        gostRepository.deleteById(id);
    }
}

