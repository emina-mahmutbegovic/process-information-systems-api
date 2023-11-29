package com.example.processinformationsystemsapplication.controller;

import com.example.processinformationsystemsapplication.entity.TerminEmitovanja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.processinformationsystemsapplication.service.TerminEmitovanjaService;

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
    public ResponseEntity<TerminEmitovanja> createTerminEmitovanja(@RequestBody TerminEmitovanja terminEmitovanja) {
        TerminEmitovanja createdTerminEmitovanja = terminEmitovanjaService.createTerminEmitovanja(terminEmitovanja);
        return new ResponseEntity<>(createdTerminEmitovanja, HttpStatus.CREATED);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<TerminEmitovanja>> getAllTerminiEmitovanja() {
        List<TerminEmitovanja> terminiEmitovanja = terminEmitovanjaService.getAllTerminiEmitovanja();
        return new ResponseEntity<>(terminiEmitovanja, HttpStatus.OK);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<TerminEmitovanja> getTerminEmitovanjaById(@PathVariable String id) {
        return terminEmitovanjaService.getTerminEmitovanjaByEpisodeId(id)
                .map(terminEmitovanja -> new ResponseEntity<>(terminEmitovanja, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<TerminEmitovanja> updateTerminEmitovanja(@PathVariable String id, @RequestBody TerminEmitovanja updatedTerminEmitovanja) {
        return terminEmitovanjaService.updateTerminEmitovanjaByEpisodeId(id, updatedTerminEmitovanja)
                .map(terminEmitovanja -> new ResponseEntity<>(terminEmitovanja, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerminEmitovanja(@PathVariable String id) {
        terminEmitovanjaService.deleteTerminEmitovanjaByEpisodeId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

