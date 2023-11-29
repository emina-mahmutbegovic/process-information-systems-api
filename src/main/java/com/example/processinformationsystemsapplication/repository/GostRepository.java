package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.Gost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GostRepository extends JpaRepository<Gost, String> {
    // You can add custom queries or methods here if needed
}
