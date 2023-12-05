package com.example.processinformationsystemsapplication.controller;

import com.example.processinformationsystemsapplication.entity.Epizoda;
import com.example.processinformationsystemsapplication.model.EpizodaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.processinformationsystemsapplication.service.EpizodaService;

import java.util.List;

@RestController
@RequestMapping("/api/epizode")
public class EpizodaController {

    private final EpizodaService epizodaService;

    @Autowired
    public EpizodaController(EpizodaService epizodaService) {
        this.epizodaService = epizodaService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Epizoda> createEpizoda(@RequestBody EpizodaModel epizoda) {
        Epizoda createdEpizoda = epizodaService.createEpizoda(epizoda);
        return new ResponseEntity<>(createdEpizoda, HttpStatus.CREATED);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<Epizoda>> getAllEpizode() {
        List<Epizoda> epizode = epizodaService.getAllEpizode();
        return new ResponseEntity<>(epizode, HttpStatus.OK);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Epizoda> getEpizodaById(@PathVariable String id) {
        return epizodaService.getEpizodaById(id)
                .map(epizoda -> new ResponseEntity<>(epizoda, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<Epizoda> updateEpizodaById(@PathVariable String id, @RequestBody Epizoda updatedEpizoda) {
        return epizodaService.updateEpizoda(id, updatedEpizoda)
                .map(epizoda -> new ResponseEntity<>(epizoda, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpizoda(@PathVariable String id) {
        epizodaService.deleteEpizoda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

