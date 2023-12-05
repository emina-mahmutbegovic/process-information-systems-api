package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.Urednik;
import com.example.processinformationsystemsapplication.exception.BadRequestException;
import com.example.processinformationsystemsapplication.model.UrednikModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.processinformationsystemsapplication.repository.UrednikRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UrednikService {

    private final UrednikRepository urednikRepository;

    @Autowired
    public UrednikService(UrednikRepository urednikRepository) {
        this.urednikRepository = urednikRepository;
    }

    // Create
    public Urednik createUrednik(UrednikModel urednikModel) {
        // Check if urednik with a specified number already exists
        Optional<Urednik> existingKontaktTelefon = urednikRepository.findUrednikByKontaktTelefonUrednika(urednikModel.kontaktTelefonUrednika());

        if(existingKontaktTelefon.isPresent()) {
            throw new BadRequestException(String.format("Urednik sa brojem %s vec postoji.", urednikModel.kontaktTelefonUrednika()));
        }

        // Check if urednik already exists
        Optional<Urednik> existingUrednik = urednikRepository.findUrednikByImeUrednikaAndPrezimeUrednikaAndKontaktTelefonUrednika(
                urednikModel.imeUrednika(),
                urednikModel.prezimeUrednika(),
                urednikModel.kontaktTelefonUrednika());

        if(existingUrednik.isPresent()) {
            throw new BadRequestException(String.format("Urednik %s %s vec postoji.", urednikModel.imeUrednika(), urednikModel.prezimeUrednika()));
        }

        Urednik urednik = new Urednik(urednikModel.imeUrednika(),
                urednikModel.prezimeUrednika(),
                urednikModel.kontaktTelefonUrednika());

        return urednikRepository.save(urednik);
    }

    // Read All
    public List<Urednik> getAllUrednici() {
        return urednikRepository.findAll();
    }

    // Read by ID
    public Optional<Urednik> getUrednikById(String id) {
        return urednikRepository.findById(id);
    }

    // Update by ID
    public Optional<Urednik> updateUrednik(String id, Urednik updatedUrednik) {
        return urednikRepository.findById(id)
                .map(existingUrednik -> {
                    existingUrednik.setImeUrednika(updatedUrednik.getImeUrednika());
                    existingUrednik.setPrezimeUrednika(updatedUrednik.getPrezimeUrednika());
                    existingUrednik.setKontaktTelefonUrednika(updatedUrednik.getKontaktTelefonUrednika());
                    // Add other fields to update as needed
                    return urednikRepository.save(existingUrednik);
                });
    }

    // Delete by ID
    public void deleteUrednik(String id) {
        urednikRepository.deleteById(id);
    }
}

