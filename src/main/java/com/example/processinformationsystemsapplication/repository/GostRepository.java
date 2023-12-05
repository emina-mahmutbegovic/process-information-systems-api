package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.Gost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GostRepository extends JpaRepository<Gost, String> {
    Optional<Gost> findGostByKontaktTelefonGosta(String kontaktTelefonGosta);
    Optional<Gost> findByImeGostaAndPrezimeGostaAndKontaktTelefonGosta(
            String imeGosta,
            String prezimeGosta,
            String kontaktTelefonGosta
    );
}
