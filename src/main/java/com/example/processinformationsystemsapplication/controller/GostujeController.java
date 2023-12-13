package com.example.processinformationsystemsapplication.controller;

import com.example.processinformationsystemsapplication.entity.Emisija;
import com.example.processinformationsystemsapplication.entity.Gostuje;
import com.example.processinformationsystemsapplication.service.GostujeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gostuje")
public class GostujeController {
    private final GostujeService gostujeService;

    @Autowired
    public GostujeController(GostujeService gostujeService) {
        this.gostujeService = gostujeService;
    }

    @GetMapping("/{idEmisije}")
    public ResponseEntity<List<Gostuje>> getAllGostujeForEmisija(@PathVariable String idEmisije) {
        List<Gostuje> gostuje = this.gostujeService.getAllByIdEmisije(idEmisije);
        return new ResponseEntity<>(gostuje, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteGostujeByIdGosta(@RequestParam ("idGosta") String idGosta, @RequestParam ("idEmisije") String idEmisije) {
        gostujeService.deleteGostujeByIdGostaAndIdEmisije(idGosta, idEmisije);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
