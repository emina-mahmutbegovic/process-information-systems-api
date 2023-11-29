package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.TerminEmitovanja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.processinformationsystemsapplication.repository.TerminEmitovanjaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TerminEmitovanjaService {

    private final TerminEmitovanjaRepository terminEmitovanjaRepository;

    @Autowired
    public TerminEmitovanjaService(TerminEmitovanjaRepository terminEmitovanjaRepository) {
        this.terminEmitovanjaRepository = terminEmitovanjaRepository;
    }

    // Create
    public TerminEmitovanja createTerminEmitovanja(TerminEmitovanja terminEmitovanja) {
        return terminEmitovanjaRepository.save(terminEmitovanja);
    }

    // Read All
    public List<TerminEmitovanja> getAllTerminiEmitovanja() {
        return terminEmitovanjaRepository.findAll();
    }

    // Read by ID
    public Optional<TerminEmitovanja> getTerminEmitovanjaByEpisodeId(String id) {
        return terminEmitovanjaRepository.findByEpisodeId(id);
    }

    // Update by ID
    public Optional<TerminEmitovanja> updateTerminEmitovanjaByEpisodeId(String id, TerminEmitovanja updatedTerminEmitovanja) {
        return terminEmitovanjaRepository.findByEpisodeId(id)
                .map(existingTermin -> {
                    existingTermin.setVrijemePocetka(updatedTerminEmitovanja.getVrijemePocetka());
                    existingTermin.setVrijemeZavrsetka(updatedTerminEmitovanja.getVrijemeZavrsetka());
                    existingTermin.setDatumEmitovanja(updatedTerminEmitovanja.getDatumEmitovanja());
                    // Add other fields to update as needed
                    return terminEmitovanjaRepository.save(existingTermin);
                });
    }

    // Delete by ID
    public void deleteTerminEmitovanjaByEpisodeId(String id) {
        terminEmitovanjaRepository.deleteByEpisodeId(id);
    }
}

