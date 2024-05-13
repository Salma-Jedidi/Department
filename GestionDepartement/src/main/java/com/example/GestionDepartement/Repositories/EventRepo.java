package com.example.GestionDepartement.Repositories;

import com.example.GestionDepartement.Entities.Etudiant;
import com.example.GestionDepartement.Entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.Date;

public interface EventRepo extends JpaRepository<Evenement, Integer> {
    Evenement findByEtudiantAndJourCoursAndHeureCours(Etudiant etudiant, Date jourCours, LocalTime heureCours);
}
