package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.Epizoda;
import com.example.processinformationsystemsapplication.entity.TerminEmitovanja;
import com.example.processinformationsystemsapplication.exception.BadRequestException;
import com.example.processinformationsystemsapplication.exception.ResourceNotFoundException;
import com.example.processinformationsystemsapplication.model.TerminEmitovanjaModel;
import com.example.processinformationsystemsapplication.repository.EpizodaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.processinformationsystemsapplication.repository.TerminEmitovanjaRepository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class TerminEmitovanjaService {

    private final TerminEmitovanjaRepository terminEmitovanjaRepository;
    private final EpizodaRepository epizodaRepository;

    @Autowired
    public TerminEmitovanjaService(TerminEmitovanjaRepository terminEmitovanjaRepository,
                                   EpizodaRepository epizodaRepository) {
        this.terminEmitovanjaRepository = terminEmitovanjaRepository;
        this.epizodaRepository = epizodaRepository;
    }

    // Create
    public TerminEmitovanja createTerminEmitovanja(TerminEmitovanjaModel terminEmitovanjaModel) {
        // Check if epizoda exists
        Optional<Epizoda> epizoda = epizodaRepository.findById(terminEmitovanjaModel.idEpizode());
        if(epizoda.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Epizoda za ID: %s ne postoji. " +
                    "Molimo Vas da najprije kreirate epizodu ili upotrijebite postojecu.", terminEmitovanjaModel.idEpizode()));
        }

        // Check if termin emitovanja already exists
        Optional<TerminEmitovanja> existingTerminEmitovanja = terminEmitovanjaRepository.findTerminEmitovanjaByVrijemePocetka(terminEmitovanjaModel.vrijemePocetka());
        if(existingTerminEmitovanja.isPresent()) {
            throw new BadRequestException(String.format("Epizoda sa vremenom pocetka %s vec postoji. Molimo Vas da odaberete drugo vrijeme pocetka.", terminEmitovanjaModel.vrijemePocetka()));
        }

        // Verify if vrijemeZavrsetka is before or equal to vrijemePocetka
        if(terminEmitovanjaModel.vrijemeZavrsetka().toLocalTime().isBefore(terminEmitovanjaModel.vrijemePocetka().toLocalTime()) ||
        terminEmitovanjaModel.vrijemePocetka().toLocalTime().equals(terminEmitovanjaModel.vrijemeZavrsetka().toLocalTime())) {
            throw new BadRequestException("Vrijeme zavrsetka ne moze biti prije vremena pocetka. Molimo Vas da ispravno podesite termine emitovanja.");
        }

        TerminEmitovanja terminEmitovanja = new TerminEmitovanja(
                terminEmitovanjaModel.vrijemePocetka(),
                terminEmitovanjaModel.vrijemeZavrsetka(),
                terminEmitovanjaModel.datumEmitovanja(),
                epizoda.get()
        );

        return terminEmitovanjaRepository.save(terminEmitovanja);
    }

    // Read All
    public List<TerminEmitovanja> getAllTerminiEmitovanja() {
        return terminEmitovanjaRepository.findAll();
    }

    // Read by ID
    public Optional<List<TerminEmitovanja>> getTerminEmitovanjaByIdEpizode(String id) {
        return terminEmitovanjaRepository.findAllByEpisodeId(id);
    }

    // Update by Episode ID and start time
    @Transactional
    public TerminEmitovanja updateTerminEmitovanjaByIdEpizodeAndVrijemePocetka(String id, Time vrijemePocetka, TerminEmitovanja updatedTerminEmitovanja) {
        // Check if Termin emitovanja exists
        Optional<TerminEmitovanja> existingTerminEmitovanja = terminEmitovanjaRepository.findByVrijemePocetkaAndIdEpizode(vrijemePocetka, id);
        if(existingTerminEmitovanja.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Termin emitovanja za ID: %s i vrijeme pocetka %s ne postoji. " +
                    "Molimo Vas da najprije kreirate epizodu ili upotrijebite drugi termin.", id, vrijemePocetka));
        }

        deleteTerminiEmitovanjaByIdEpizodeAndVrijemePocetka(id, vrijemePocetka);

        return createTerminEmitovanja(new TerminEmitovanjaModel(
                updatedTerminEmitovanja.getVrijemePocetka(),
                updatedTerminEmitovanja.getVrijemeZavrsetka(),
                updatedTerminEmitovanja.getDatumEmitovanja(),
                id));
    }

    // Delete by Episode ID and start time
    @Transactional
    public void deleteTerminiEmitovanjaByIdEpizodeAndVrijemePocetka(String idEpizode, Time vrijemePocetka) {
        terminEmitovanjaRepository.deleteByIdEpizodeAndVrijemePocetka(idEpizode, vrijemePocetka);
    }
}

