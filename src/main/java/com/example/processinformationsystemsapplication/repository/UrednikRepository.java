package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.Urednik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrednikRepository extends JpaRepository<Urednik, String> {
    Optional<Urednik> findUrednikByKontaktTelefonUrednika(String kontaktTelefonUrednika);
    Optional<Urednik> findUrednikByImeUrednikaAndPrezimeUrednikaAndKontaktTelefonUrednika(
            String imeUrednika,
            String prezimeUrednika,
            String kontaktTelefonUrednika
    );
}
