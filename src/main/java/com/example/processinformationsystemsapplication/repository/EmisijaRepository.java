package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.Emisija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmisijaRepository extends JpaRepository<Emisija, String> {
    // You can add custom queries or methods here if needed
}

