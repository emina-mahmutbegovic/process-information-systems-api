package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.*;
import com.example.processinformationsystemsapplication.exception.BadRequestException;
import com.example.processinformationsystemsapplication.exception.ResourceNotFoundException;
import com.example.processinformationsystemsapplication.model.EmisijaModel;
import com.example.processinformationsystemsapplication.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmisijaService {

    private final EmisijaRepository emisijaRepository;
    private final VrstaEmisijeRepository vrstaEmisijeRepository;
    private final VoditeljRepository voditeljRepository;
    private final UrednikRepository urednikRepository;
    private final GostRepository gostRepository;

    @Autowired
    public EmisijaService(EmisijaRepository emisijaRepository,
                          VrstaEmisijeRepository vrstaEmisijeRepository,
                          VoditeljRepository voditeljRepository,
                          UrednikRepository urednikRepository,
                          GostRepository gostRepository) {
        this.emisijaRepository = emisijaRepository;
        this.vrstaEmisijeRepository = vrstaEmisijeRepository;
        this.voditeljRepository = voditeljRepository;
        this.urednikRepository = urednikRepository;
        this.gostRepository = gostRepository;
    }

    // Create
    public Emisija createEmisija(EmisijaModel emisijaModel) throws BadRequestException, ResourceNotFoundException {
        // Check if emisija already exists
        Optional<Emisija> existingEmisija = emisijaRepository.findEmisijaByNazivEmisije(emisijaModel.nazivEmisije());
        if(existingEmisija.isPresent()) {
            throw new BadRequestException(String.format("Emisija %s vec postoji. Molimo Vas da odaberete drugi naziv emisije.", emisijaModel.nazivEmisije()));
        }

        // Get common entities
        Optional<VrstaEmisije> vrstaEmisije = vrstaEmisijeRepository.findById(emisijaModel.idVrsteEmisije());
        if(vrstaEmisije.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Vrsta emisije za ID: %s ne postoji. " +
                    "Molimo Vas da najprije kreirate vrstu emisije, ili upotrijebite postojecu vrstu.", emisijaModel.idVrsteEmisije()));
        }

        Optional<Voditelj> voditelj = voditeljRepository.findById(emisijaModel.idVoditelja());
        if(voditelj.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Voditelj za ID: %s ne postoji. " +
                    "Molimo Vas da najprije kreirate voditelja ili upotrijebite postojeceg voditelja.", emisijaModel.idVoditelja()));
        }

        Optional<Urednik> urednik = urednikRepository.findById(emisijaModel.idUrednika());
        if(urednik.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Urednik za ID: %s ne postoji. " +
                    "Molimo Vas da najprije kreirate urednika ili upotrijebite postojeceg urednika.", emisijaModel.idUrednika()));
        }

        Optional<Gost> gost = gostRepository.findById(emisijaModel.idGosta());
        if(gost.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Gost za ID: %s ne postoji. " +
                    "Molimo Vas da najprije kreirate gosta ili upotrijebite postojeceg gosta.", emisijaModel.idGosta()));
        }

        Emisija emisija = new Emisija(emisijaModel.nazivEmisije(),
                                    emisijaModel.opisEmisije(),
                                    emisijaModel.trajanjeEmisije(),
                                    emisijaModel.ocjenaEmisije(),
                                    vrstaEmisije.get(),
                                    voditelj.get(),
                                    urednik.get(),
                                    gost.get());

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

