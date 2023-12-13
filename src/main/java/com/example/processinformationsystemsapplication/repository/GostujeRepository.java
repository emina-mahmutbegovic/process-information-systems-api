package com.example.processinformationsystemsapplication.repository;

import com.example.processinformationsystemsapplication.entity.Gostuje;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GostujeRepository extends JpaRepository<Gostuje, String> {
    @Query("SELECT gs FROM Gostuje gs WHERE gs.id_emisije = :idEmisije")
    List<Gostuje> getAllById_emisije(String idEmisije);

    @Modifying
    @Transactional
    @Query("DELETE FROM Gostuje gs WHERE gs.id_gosta = ?1 AND gs.id_emisije = ?2")
    void deleteGostujeByPrimaryKey(String idGosta, String idEmisije);
}
