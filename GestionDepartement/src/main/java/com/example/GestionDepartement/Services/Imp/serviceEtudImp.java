package com.example.GestionDepartement.Services.Imp;

import com.example.GestionDepartement.Entities.Abscentisme;
import com.example.GestionDepartement.Entities.Etudiant;
import com.example.GestionDepartement.Entities.Evenement;
import com.example.GestionDepartement.Entities.Reussite;
import com.example.GestionDepartement.Repositories.EtudiantRepo;
import com.example.GestionDepartement.Repositories.EventRepo;
import com.example.GestionDepartement.Services.serviceEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Service
public class serviceEtudImp implements serviceEtudiant {
    @Autowired
    EtudiantRepo etudiantRepo;
    @Autowired
    EventRepo eventRepo;

    public Etudiant addEtudiant(Etudiant etudiant) {
        System.out.println("Ajout de l'étudiant : {}");
        return etudiantRepo.save(etudiant);
    }

    @Override
    public Evenement addEvent(Evenement event) {
        return eventRepo.save(event);
    }

    @Override
    public void marquerPresence(String nomEtudiant, Date jourCours, LocalTime heureCours) {

        Etudiant etudiant = etudiantRepo.findByNomEtudiant(nomEtudiant);

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

    @Override
    public Etudiant getEtudiant(Integer id) {
        return etudiantRepo.findById(id).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepo.findAll();
    }
}