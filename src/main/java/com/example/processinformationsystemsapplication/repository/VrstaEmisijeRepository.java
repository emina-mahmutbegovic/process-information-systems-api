package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.VrstaEmisije;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VrstaEmisijeRepository extends JpaRepository<VrstaEmisije, String> {
    Optional<VrstaEmisije> findVrstaEmisijeByNazivVrsteEmisije(String nazivVrsteEmisije);
}
