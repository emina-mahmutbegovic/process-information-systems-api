package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.Emisija;
import com.example.processinformationsystemsapplication.entity.Epizoda;
import com.example.processinformationsystemsapplication.exception.BadRequestException;
import com.example.processinformationsystemsapplication.exception.ResourceNotFoundException;
import com.example.processinformationsystemsapplication.model.EpizodaModel;
import com.example.processinformationsystemsapplication.repository.EmisijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.processinformationsystemsapplication.repository.EpizodaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EpizodaService {

    private final EpizodaRepository epizodaRepository;
    private final EmisijaRepository emisijaRepository;

    @Autowired
    public EpizodaService(EpizodaRepository epizodaRepository,
                          EmisijaRepository emisijaRepository) {
        this.epizodaRepository = epizodaRepository;
        this.emisijaRepository = emisijaRepository;
    }

    // Create
    public Epizoda createEpizoda(EpizodaModel epizodaModel) {
        // Check if emisija exists
        Optional<Emisija> emisija = emisijaRepository.findById(epizodaModel.idEmisije());
        if(emisija.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Emisija za ID: %s ne postoji. " +
                    "Molimo Vas da najprije kreirate emisiju ili upotrijebite postojecu.", epizodaModel.idEmisije()));
        }

        // Check if episode and season for a show exist
        Optional<Epizoda> existingEpizoda = epizodaRepository.findEpizodaByIdEmisijeAndBrojEpizodeAndBrojSezone(
                epizodaModel.idEmisije(),
                epizodaModel.brojEpizode(),
                epizodaModel.brojSezone());
        if(existingEpizoda.isPresent()) {
            throw new BadRequestException(String.format("Epizoda za ID %s, broj sezone %d i broj epizode %d vec postoji. " +
                    "Molimo Vas da odaberete drugu emisiju, epizodu ili sezonu.", epizodaModel.idEmisije(), epizodaModel.brojEpizode(), epizodaModel.brojSezone()));
        }

        Epizoda epizoda = new Epizoda(epizodaModel.nazivEpizode(),
                epizodaModel.brojEpizode(),
                epizodaModel.brojSezone(),
                epizodaModel.opisEpizode(),
                emisija.get());

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

