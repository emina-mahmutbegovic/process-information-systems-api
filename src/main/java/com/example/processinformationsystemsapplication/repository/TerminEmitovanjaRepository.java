package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.TerminEmitovanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface TerminEmitovanjaRepository extends JpaRepository<TerminEmitovanja, Time> {
    Optional<TerminEmitovanja> findTerminEmitovanjaByVrijemePocetka(Time vrijemePocetka);
    @Query("SELECT te FROM TerminEmitovanja te WHERE te.vrijemePocetka = :vrijemePocetka AND te.epizoda.idEpizode = :idEpizode")
    Optional<TerminEmitovanja> findByVrijemePocetkaAndIdEpizode(@Param("vrijemePocetka") Time vrijemePocetka, @Param("idEpizode") String idEpizode);

    @Query("SELECT te FROM TerminEmitovanja te WHERE te.epizoda.idEpizode = :id")
    Optional<List<TerminEmitovanja>> findAllByEpisodeId(@Param("id") String id);

    @Modifying
    @Query("DELETE FROM TerminEmitovanja te WHERE te.epizoda.idEpizode = :idEpizode AND te.vrijemePocetka = :vrijemePocetka")
    void deleteByIdEpizodeAndVrijemePocetka(@Param("idEpizode") String idEpizode, @Param("vrijemePocetka") Time vrijemePocetka);
}
