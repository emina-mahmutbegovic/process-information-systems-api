package com.example.processinformationsystemsapplication.controller;

import com.example.processinformationsystemsapplication.entity.Voditelj;
import com.example.processinformationsystemsapplication.model.VoditeljModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.processinformationsystemsapplication.service.VoditeljService;

import java.util.List;

@RestController
@RequestMapping("/api/voditelji")
public class VoditeljController {

    private final VoditeljService voditeljService;

    @Autowired
    public VoditeljController(VoditeljService voditeljService) {
        this.voditeljService = voditeljService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Voditelj> createVoditelj(@RequestBody VoditeljModel voditelj) {
        Voditelj createdVoditelj = voditeljService.createVoditelj(voditelj);
        return new ResponseEntity<>(createdVoditelj, HttpStatus.CREATED);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<Voditelj>> getAllVoditelji() {
        List<Voditelj> voditelji = voditeljService.getAllVoditelji();
        return new ResponseEntity<>(voditelji, HttpStatus.OK);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Voditelj> getVoditeljById(@PathVariable String id) {
        return voditeljService.getVoditeljById(id)
                .map(voditelj -> new ResponseEntity<>(voditelj, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<Voditelj> updateVoditeljById(@PathVariable String id, @RequestBody Voditelj updatedVoditelj) {
        return voditeljService.updateVoditelj(id, updatedVoditelj)
                .map(voditelj -> new ResponseEntity<>(voditelj, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoditelj(@PathVariable String id) {
        voditeljService.deleteVoditelj(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

