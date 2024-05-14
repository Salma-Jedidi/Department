package com.example.GestionDepartement.Repositories;

import com.example.GestionDepartement.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepo extends JpaRepository<Etudiant, Integer> {
    Etudiant findByNomEtudiant(String nom);

}
