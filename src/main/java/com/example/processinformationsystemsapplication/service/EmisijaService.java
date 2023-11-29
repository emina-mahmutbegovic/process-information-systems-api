package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.Emisija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.processinformationsystemsapplication.repository.EmisijaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmisijaService {

    private final EmisijaRepository emisijaRepository;

    @Autowired
    public EmisijaService(EmisijaRepository emisijaRepository) {
        this.emisijaRepository = emisijaRepository;
    }

    // Create
    public Emisija createEmisija(Emisija emisija) {
        return emisijaRepository.save(emisija);
    }

    // Read All
    public List<Emisija> getAllEmisije() {
        return emisijaRepository.findAll();
    }

    // Read by ID
    public Optional<Emisija> getEmisijaById(String id) {
        return emisijaRepository.findById(id);
    }

    // Update by ID
    public Optional<Emisija> updateEmisija(String id, Emisija updatedEmisija) {
        return emisijaRepository.findById(id)
                .map(existingEmisija -> {
                    existingEmisija.setNazivEmisije(updatedEmisija.getNazivEmisije());
                    existingEmisija.setOpisEmisije(updatedEmisija.getOpisEmisije());
                    existingEmisija.setTrajanjeEmisije(updatedEmisija.getTrajanjeEmisije());
                    existingEmisija.setOcjenaEmisije(updatedEmisija.getOcjenaEmisije());
                    // Add other fields to update as needed
                    return emisijaRepository.save(existingEmisija);
                });
    }

    // Delete by ID
    public void deleteEmisija(String id) {
        emisijaRepository.deleteById(id);
    }
}

