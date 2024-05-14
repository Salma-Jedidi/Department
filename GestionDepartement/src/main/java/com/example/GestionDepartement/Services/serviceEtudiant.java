package com.example.GestionDepartement.Services;

import com.example.GestionDepartement.Entities.Etudiant;
import com.example.GestionDepartement.Entities.Evenement;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface serviceEtudiant {
    public Etudiant addEtudiant(Etudiant etudiant);
    public void marquerReussite(Etudiant etudiant);

    Evenement addEvent(Evenement event);

    public void marquerPresence(String nomEtudiant, Date jourCours, LocalTime heureCours);

    double calculerPourcentageAbsentisme();

    double calculerPourcentageReussite();
    Etudiant getEtudiant(Integer id);
    List<Etudiant> getAllEtudiants();
}
