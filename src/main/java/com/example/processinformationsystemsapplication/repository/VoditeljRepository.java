package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.Voditelj;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoditeljRepository extends JpaRepository<Voditelj, String> {
    Optional<Voditelj> findVoditeljByKontaktTelefonVoditelja(String kontaktTelefonVoditelja);
    Optional<Voditelj> findVoditeljByImeVoditeljaAndPrezimeVoditeljaAndKontaktTelefonVoditelja(
            String imeVoditelja,
            String prezimeVoditelja,
            String kontaktTelefonVoditelja
    );
}
