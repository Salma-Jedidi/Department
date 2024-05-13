package com.example.GestionDepartement.Services.Imp;

import com.example.GestionDepartement.Services.serviceEtudiant;
import com.example.GestionDepartement.Entities.*;
import com.example.GestionDepartement.Repositories.EtudiantRepo;
import com.example.GestionDepartement.Repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class serviceEtudImp implements serviceEtudiant{
    @Autowired
    EtudiantRepo etudiantRepo;
    @Autowired
    EventRepo eventRepo;
    public Etudiant addEtudiant(Etudiant etudiant){
        return etudiantRepo.save(etudiant);
    }
    @Override
    public Evenement addEvent(Evenement event){
        return eventRepo.save(event);
    }
    @Override
    public void marquerPresence(String nomEtudiant, Date jourCours, LocalTime heureCours) {

        Etudiant etudiant = etudiantRepo.findByNom(nomEtudiant);

        if (etudiant != null) {

            Evenement evenement = eventRepo.findByEtudiantAndJourCoursAndHeureCours(etudiant, jourCours, heureCours);


            if (evenement != null) {
                evenement.setAbscentisme(Abscentisme.PRESENT);
                eventRepo.save(evenement);
            }
        }
    }
    @Override
    public void marquerReussite(Etudiant etudiant) {

        etudiant.setReussite(Reussite.REUSSI);
        etudiantRepo.save(etudiant);
    }
    @Override
    public double calculerPourcentageAbsentisme() {

        List<Evenement> evenements = eventRepo.findAll();

        long nombreAbsent = evenements.stream()
                .filter(e -> e.getAbscentisme() == Abscentisme.ABSCENT)
                .count();


        double pourcentageAbsentisme = (double) nombreAbsent / evenements.size() * 100;

        return pourcentageAbsentisme;
    }

    @Override
    public double calculerPourcentageReussite() {

        List<Etudiant> etudiants = etudiantRepo.findAll();


        long nombreReussite = etudiants.stream()
                .filter(e -> e.getReussite() == Reussite.REUSSI)
                .count();


        double pourcentageReussite = (double) nombreReussite / etudiants.size() * 100;

        return pourcentageReussite;
    }
}
