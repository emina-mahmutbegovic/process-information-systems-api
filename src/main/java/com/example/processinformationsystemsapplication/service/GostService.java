package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.Gost;
import com.example.processinformationsystemsapplication.exception.BadRequestException;
import com.example.processinformationsystemsapplication.model.GostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.processinformationsystemsapplication.repository.GostRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GostService {

    private final GostRepository gostRepository;

    @Autowired
    public GostService(GostRepository gostRepository) {
        this.gostRepository = gostRepository;
    }

    // Create
    public Gost createGost(GostModel gostModel) {
        // Check if gost with a specified number already exists
        Optional<Gost> existingKontaktTelefon = gostRepository.findGostByKontaktTelefonGosta(gostModel.kontaktTelefonGosta());

        if(existingKontaktTelefon.isPresent()) {
            throw new BadRequestException(String.format("Gost sa brojem %s vec postoji.", gostModel.kontaktTelefonGosta()));
        }

        // Check if gost already exists
        Optional<Gost> existingGost = gostRepository.findByImeGostaAndPrezimeGostaAndKontaktTelefonGosta(
                gostModel.imeGosta(),
                gostModel.prezimeGosta(),
                gostModel.kontaktTelefonGosta());

        if(existingGost.isPresent()) {
            throw new BadRequestException(String.format("Gost %s %s vec postoji.", gostModel.imeGosta(), gostModel.prezimeGosta()));
        }

        Gost gost = new Gost(gostModel.imeGosta(),
                            gostModel.prezimeGosta(),
                            gostModel.biografijaGosta(),
                            gostModel.kontaktTelefonGosta());

        return gostRepository.save(gost);
    }

    // Read All
    public List<Gost> getAllGosti(Set<String> idGostiju) {
        if(idGostiju.isEmpty()) return gostRepository.findAll();
        else return gostRepository.findAllByIdGostaIn(idGostiju);

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

