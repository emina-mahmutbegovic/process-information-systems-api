package com.example.processinformationsystemsapplication.service;

import com.example.processinformationsystemsapplication.entity.Gostuje;
import com.example.processinformationsystemsapplication.repository.GostujeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GostujeService {

    private final GostujeRepository gostujeRepository;

    @Autowired
    public GostujeService(GostujeRepository gostujeRepository) {
        this.gostujeRepository = gostujeRepository;
    }

    public List<Gostuje> getAllByIdEmisije(String idEmisije) {
        return this.gostujeRepository.getAllById_emisije(idEmisije);
    }

    public void deleteGostujeByIdGostaAndIdEmisije(String idGosta, String idEmisije) {
        this.gostujeRepository.deleteGostujeByPrimaryKey(idGosta, idEmisije);
    }
}

