package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.Emisija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmisijaRepository extends JpaRepository<Emisija, String> {
    Optional<Emisija> findEmisijaByNazivEmisije(String nazivEmisije);
}

