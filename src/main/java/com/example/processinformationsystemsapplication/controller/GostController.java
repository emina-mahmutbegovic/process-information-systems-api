package com.example.processinformationsystemsapplication.controller;

import com.example.processinformationsystemsapplication.entity.Gost;
import com.example.processinformationsystemsapplication.model.GostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.processinformationsystemsapplication.service.GostService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/gosti")
public class GostController {

    private final GostService gostService;

    @Autowired
    public GostController(GostService gostService) {
        this.gostService = gostService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Gost> createGost(@RequestBody GostModel gost) {
        Gost createdGost = gostService.createGost(gost);
        return new ResponseEntity<>(createdGost, HttpStatus.CREATED);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<Gost>> getAllGosti(@RequestParam(name = "idGostiju") Set<String> idGostiju) {
        List<Gost> gosti = gostService.getAllGosti(idGostiju);
        return new ResponseEntity<>(gosti, HttpStatus.OK);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Gost> getGostById(@PathVariable String id) {
        return gostService.getGostById(id)
                .map(gost -> new ResponseEntity<>(gost, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<Gost> updateGostById(@PathVariable String id, @RequestBody Gost updatedGost) {
        return gostService.updateGost(id, updatedGost)
                .map(gost -> new ResponseEntity<>(gost, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGost(@PathVariable String id) {
        gostService.deleteGost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

