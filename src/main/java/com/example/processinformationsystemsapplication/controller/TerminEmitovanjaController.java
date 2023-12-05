package com.example.processinformationsystemsapplication.controller;

import com.example.processinformationsystemsapplication.entity.TerminEmitovanja;
import com.example.processinformationsystemsapplication.model.TerminEmitovanjaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.processinformationsystemsapplication.service.TerminEmitovanjaService;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/api/termini-emitovanja")
public class TerminEmitovanjaController {

    private final TerminEmitovanjaService terminEmitovanjaService;

    @Autowired
    public TerminEmitovanjaController(TerminEmitovanjaService terminEmitovanjaService) {
        this.terminEmitovanjaService = terminEmitovanjaService;
    }

    // Create
    @PostMapping
    public ResponseEntity<TerminEmitovanja> createTerminEmitovanja(@RequestBody TerminEmitovanjaModel terminEmitovanja) {
        TerminEmitovanja createdTerminEmitovanja = terminEmitovanjaService.createTerminEmitovanja(terminEmitovanja);
        return new ResponseEntity<>(createdTerminEmitovanja, HttpStatus.CREATED);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<TerminEmitovanja>> getAllTerminiEmitovanja() {
        List<TerminEmitovanja> terminiEmitovanja = terminEmitovanjaService.getAllTerminiEmitovanja();
        return new ResponseEntity<>(terminiEmitovanja, HttpStatus.OK);
    }

    // Read by Episode ID
    @GetMapping("/{id}")
    public ResponseEntity<List<TerminEmitovanja>> getTerminiEmitovanjaByIdEpizode(@PathVariable String id) {
        return terminEmitovanjaService.getTerminEmitovanjaByIdEpizode(id)
                .map(terminEmitovanja -> new ResponseEntity<>(terminEmitovanja, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update by Episode ID and Start time
    @PutMapping
    public ResponseEntity<TerminEmitovanja> updateTerminEmitovanjaByIdEpizodeAndVrijemePocetka(@RequestParam(name = "idEpizode") String idEpizode,
                                                                                                     @RequestParam(name = "vrijemePocetka") Time vrijemePocetka,
                                                                                                     @RequestBody TerminEmitovanja updatedTerminEmitovanja) {
        TerminEmitovanja savedTerminEmitovanja = terminEmitovanjaService.updateTerminEmitovanjaByIdEpizodeAndVrijemePocetka(idEpizode, vrijemePocetka, updatedTerminEmitovanja);
        return new ResponseEntity<>(savedTerminEmitovanja, HttpStatus.OK);

    }

    // Delete by Episode ID and Start Time
    @DeleteMapping
    public ResponseEntity<Void> deleteTerminEmitovanjaByIdEpizodeAndVrijemePocetka(@RequestParam(name = "idEpizode") String idEpizode,
                                                                                     @RequestParam(name = "vrijemePocetka") Time vrijemePocetka) {
        terminEmitovanjaService.deleteTerminiEmitovanjaByIdEpizodeAndVrijemePocetka(idEpizode, vrijemePocetka);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

