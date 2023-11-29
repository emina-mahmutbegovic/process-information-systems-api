package com.example.processinformationsystemsapplication.controller;

import com.example.processinformationsystemsapplication.entity.VrstaEmisije;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.processinformationsystemsapplication.service.VrstaEmisijeService;

import java.util.List;

@RestController
@RequestMapping("/api/vrsta-emisije")
public class VrstaEmisijeController {

    private final VrstaEmisijeService vrstaEmisijeService;

    @Autowired
    public VrstaEmisijeController(VrstaEmisijeService vrstaEmisijeService) {
        this.vrstaEmisijeService = vrstaEmisijeService;
    }

    // Create
    @PostMapping
    public ResponseEntity<VrstaEmisije> createVrstaEmisije(@RequestBody VrstaEmisije vrstaEmisije) {
        VrstaEmisije createdVrstaEmisije = vrstaEmisijeService.createVrstaEmisije(vrstaEmisije);
        return new ResponseEntity<>(createdVrstaEmisije, HttpStatus.CREATED);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<VrstaEmisije>> getAllVrsteEmisije() {
        List<VrstaEmisije> vrsteEmisije = vrstaEmisijeService.getAllVrsteEmisije();
        return new ResponseEntity<>(vrsteEmisije, HttpStatus.OK);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<VrstaEmisije> getVrstaEmisijeById(@PathVariable String id) {
        return vrstaEmisijeService.getVrstaEmisijeById(id)
                .map(vrstaEmisije -> new ResponseEntity<>(vrstaEmisije, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<VrstaEmisije> updateVrstaEmisijeById(@PathVariable String id, @RequestBody VrstaEmisije updatedVrstaEmisije) {
        return vrstaEmisijeService.updateVrstaEmisije(id, updatedVrstaEmisije)
                .map(vrstaEmisije -> new ResponseEntity<>(vrstaEmisije, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVrstaEmisije(@PathVariable String id) {
        vrstaEmisijeService.deleteVrstaEmisije(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

