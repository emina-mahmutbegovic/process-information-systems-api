package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.Epizoda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpizodaRepository extends JpaRepository<Epizoda, String> {
    // You can add custom queries or methods here if needed
}
