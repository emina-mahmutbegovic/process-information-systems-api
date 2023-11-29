package com.example.processinformationsystemsapplication.controller;

import com.example.processinformationsystemsapplication.entity.Urednik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.processinformationsystemsapplication.service.UrednikService;

import java.util.List;

@RestController
@RequestMapping("/api/urednici")
public class UrednikController {

    private final UrednikService urednikService;

    @Autowired
    public UrednikController(UrednikService urednikService) {
        this.urednikService = urednikService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Urednik> createUrednik(@RequestBody Urednik urednik) {
        Urednik createdUrednik = urednikService.createUrednik(urednik);
        return new ResponseEntity<>(createdUrednik, HttpStatus.CREATED);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<Urednik>> getAllUrednici() {
        List<Urednik> urednici = urednikService.getAllUrednici();
        return new ResponseEntity<>(urednici, HttpStatus.OK);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Urednik> getUrednikById(@PathVariable String id) {
        return urednikService.getUrednikById(id)
                .map(urednik -> new ResponseEntity<>(urednik, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<Urednik> updateUrednikById(@PathVariable String id, @RequestBody Urednik updatedUrednik) {
        return urednikService.updateUrednik(id, updatedUrednik)
                .map(urednik -> new ResponseEntity<>(urednik, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUrednik(@PathVariable String id) {
        urednikService.deleteUrednik(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

