package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.Epizoda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EpizodaRepository extends JpaRepository<Epizoda, String> {
    Optional<Epizoda> findEpizodaByNazivEpizode(String nazivEpizode);
    @Query("SELECT ep FROM Epizoda ep WHERE ep.emisija.idEmisije = :idEmisije AND ep.brojEpizode = :brojEpizode AND ep.brojSezone = :brojSezone")
    Optional<Epizoda> findEpizodaByIdEmisijeAndBrojEpizodeAndBrojSezone(@Param("idEmisije") String idEmisije,
                                                                        @Param("brojEpizode") int brojEpizode,
                                                                        @Param("brojSezone") int brojSezone);

    @Query("SELECT ep FROM Epizoda ep WHERE ep.emisija.idEmisije = :idEmisije")
    Optional<List<Epizoda>> findAllByIdEmisije(@Param("idEmisije") String idEmisije);
}
