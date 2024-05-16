package com.example.GestionDepartement.Controller;

import com.example.GestionDepartement.Entities.Etudiant;
import com.example.GestionDepartement.Entities.Evenement;
import com.example.GestionDepartement.Entities.Reussite;
import com.example.GestionDepartement.Services.serviceEtudiant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiants")
public class EtudiantControlleur {
    private final serviceEtudiant serviceEtudiant;
    @PostMapping("/marquer-presence")
    public void marquerPresence(@RequestBody String nomEtudiant, Date jourCours, LocalTime heureCours) {
        serviceEtudiant.marquerPresence(nomEtudiant,jourCours,heureCours);
    }
    @PutMapping("/marquer-reussite")
    public void marquerReussite(@RequestParam String nomEtudiant, @RequestParam Reussite reussite) {
        serviceEtudiant.marquerReussite(nomEtudiant, reussite);
    }

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return serviceEtudiant.addEtudiant(etudiant);
    }

    @PostMapping("/addEvent")
    public Evenement addEvent(@RequestBody Evenement event){
        return serviceEtudiant.addEvent(event);
    }

    @PostMapping("/calculer-pourcentage-absentisme")
    public double calculerPourcentageAbsentisme() {
        return serviceEtudiant.calculerPourcentageAbsentisme();
    }

    @PostMapping("/calculer-pourcentage-reussite")
    public double calculerPourcentageReussite() {
        return serviceEtudiant.calculerPourcentageReussite();
    }
}
