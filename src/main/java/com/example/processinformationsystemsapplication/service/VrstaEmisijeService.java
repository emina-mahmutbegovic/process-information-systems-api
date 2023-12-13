package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.VrstaEmisije;
import com.example.processinformationsystemsapplication.exception.BadRequestException;
import com.example.processinformationsystemsapplication.model.VrstaEmisijeModel;
import com.example.processinformationsystemsapplication.repository.VrstaEmisijeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public VrstaEmisije createVrstaEmisije(VrstaEmisijeModel vrstaEmisijeModel) {
        // Check if vrsta emisije already exists
        Optional<VrstaEmisije> existingVrstaEmisije = vrstaEmisijeRepository.findVrstaEmisijeByNazivVrsteEmisije(vrstaEmisijeModel.nazivVrsteEmisije());
        if(existingVrstaEmisije.isPresent()) {
            throw new BadRequestException(String.format("Vrsta emisije %s vec postoji. Molimo Vas da odaberete drugi naziv vrste emisije.", vrstaEmisijeModel.nazivVrsteEmisije()));
        }

        VrstaEmisije vrstaEmisije = new VrstaEmisije(vrstaEmisijeModel.nazivVrsteEmisije());

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

