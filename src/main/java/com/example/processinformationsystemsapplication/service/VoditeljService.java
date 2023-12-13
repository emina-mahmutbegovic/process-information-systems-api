package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.Voditelj;
import com.example.processinformationsystemsapplication.exception.BadRequestException;
import com.example.processinformationsystemsapplication.model.VoditeljModel;
import com.example.processinformationsystemsapplication.repository.VoditeljRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoditeljService {

    private final VoditeljRepository voditeljRepository;

    @Autowired
    public VoditeljService(VoditeljRepository voditeljRepository) {
        this.voditeljRepository = voditeljRepository;
    }

    // Create
    public Voditelj createVoditelj(VoditeljModel voditeljModel) {
        // Check if voditelj with a specified number already exists
        Optional<Voditelj> existingKontaktTelefon = voditeljRepository.findVoditeljByKontaktTelefonVoditelja(voditeljModel.kontaktTelefonVoditelja());

        if(existingKontaktTelefon.isPresent()) {
            throw new BadRequestException(String.format("Voditelj sa brojem %s vec postoji.", voditeljModel.kontaktTelefonVoditelja()));
        }

        // Check if voditelj already exists
        Optional<Voditelj> existingVoditelj = voditeljRepository.findVoditeljByImeVoditeljaAndPrezimeVoditeljaAndKontaktTelefonVoditelja(
                voditeljModel.imeVoditelja(),
                voditeljModel.prezimeVoditelja(),
                voditeljModel.kontaktTelefonVoditelja());

        if(existingVoditelj.isPresent()) {
            throw new BadRequestException(String.format("Voditelj %s %s vec postoji.", voditeljModel.imeVoditelja(), voditeljModel.prezimeVoditelja()));
        }

        Voditelj voditelj = new Voditelj(voditeljModel.imeVoditelja(),
                voditeljModel.prezimeVoditelja(),
                voditeljModel.kontaktTelefonVoditelja());

        return voditeljRepository.save(voditelj);
    }

    // Read All
    public List<Voditelj> getAllVoditelji() {
        return voditeljRepository.findAll();
    }

    // Read by ID
    public Optional<Voditelj> getVoditeljById(String id) {
        return voditeljRepository.findById(id);
    }

    // Update by ID
    public Optional<Voditelj> updateVoditelj(String id, Voditelj updatedVoditelj) {
        return voditeljRepository.findById(id)
                .map(existingVoditelj -> {
                    existingVoditelj.setImeVoditelja(updatedVoditelj.getImeVoditelja());
                    existingVoditelj.setPrezimeVoditelja(updatedVoditelj.getPrezimeVoditelja());
                    existingVoditelj.setKontaktTelefonVoditelja(updatedVoditelj.getKontaktTelefonVoditelja());
                    // Add other fields to update as needed
                    return voditeljRepository.save(existingVoditelj);
                });
    }

    // Delete by ID
    public void deleteVoditelj(String id) {
        voditeljRepository.deleteById(id);
    }
}

