package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.Voditelj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoditeljRepository extends JpaRepository<Voditelj, String> {
    // You can add custom queries or methods here if needed
}
