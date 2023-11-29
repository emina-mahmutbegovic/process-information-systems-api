package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.TerminEmitovanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Optional;

public interface TerminEmitovanjaRepository extends JpaRepository<TerminEmitovanja, Time> {
    @Query("SELECT te FROM TerminEmitovanja te WHERE te.epizoda.idEpizode = :id")
    Optional<TerminEmitovanja> findByEpisodeId(@Param("id") String id);

    @Query("DELETE FROM TerminEmitovanja te WHERE te.epizoda.idEpizode = :id")
    void deleteByEpisodeId(@Param("id") String id);
}
