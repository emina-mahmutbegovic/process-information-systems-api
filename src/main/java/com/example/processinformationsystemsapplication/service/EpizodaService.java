package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.Epizoda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.processinformationsystemsapplication.repository.EpizodaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EpizodaService {

    private final EpizodaRepository epizodaRepository;

    @Autowired
    public EpizodaService(EpizodaRepository epizodaRepository) {
        this.epizodaRepository = epizodaRepository;
    }

    // Create
    public Epizoda createEpizoda(Epizoda epizoda) {
        return epizodaRepository.save(epizoda);
    }

    // Read All
    public List<Epizoda> getAllEpizode() {
        return epizodaRepository.findAll();
    }

    // Read by ID
    public Optional<Epizoda> getEpizodaById(String id) {
        return epizodaRepository.findById(id);
    }

    // Update by ID
    public Optional<Epizoda> updateEpizoda(String id, Epizoda updatedEpizoda) {
        return epizodaRepository.findById(id)
                .map(existingEpizoda -> {
                    existingEpizoda.setNazivEpizode(updatedEpizoda.getNazivEpizode());
                    existingEpizoda.setBrojEpizode(updatedEpizoda.getBrojEpizode());
                    existingEpizoda.setBrojSezone(updatedEpizoda.getBrojSezone());
                    existingEpizoda.setOpisEpizode(updatedEpizoda.getOpisEpizode());
                    // Add other fields to update as needed
                    return epizodaRepository.save(existingEpizoda);
                });
    }

    // Delete by ID
    public void deleteEpizoda(String id) {
        epizodaRepository.deleteById(id);
    }
}

