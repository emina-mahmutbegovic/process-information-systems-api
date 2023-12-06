package com.example.processinformationsystemsapplication.controller;

import com.example.processinformationsystemsapplication.entity.Emisija;
import com.example.processinformationsystemsapplication.exception.BadRequestException;
import com.example.processinformationsystemsapplication.exception.ResourceNotFoundException;
import com.example.processinformationsystemsapplication.model.EmisijaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.processinformationsystemsapplication.service.EmisijaService;

import java.util.List;

@RestController
@RequestMapping("/api/emisije")
public class EmisijaController {

    private final EmisijaService emisijaService;

    @Autowired
    public EmisijaController(EmisijaService emisijaService) {
        this.emisijaService = emisijaService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Emisija> createEmisija(@RequestBody EmisijaModel emisija) {
        Emisija createdEmisija = emisijaService.createEmisija(emisija);
        return new ResponseEntity<>(createdEmisija, HttpStatus.CREATED);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<Emisija>> getAllEmisije() {
        List<Emisija> emisije = emisijaService.getAllEmisije();
        return new ResponseEntity<>(emisije, HttpStatus.OK);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Emisija> getEmisijaById(@PathVariable String id) {
        return emisijaService.getEmisijaById(id)
                .map(emisija -> new ResponseEntity<>(emisija, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<Emisija> updateEmisijaById(@PathVariable String id, @RequestBody Emisija updatedEmisija) {
        return emisijaService.updateEmisija(id, updatedEmisija)
                .map(emisija -> new ResponseEntity<>(emisija, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmisija(@PathVariable String id) {
        emisijaService.deleteEmisija(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

