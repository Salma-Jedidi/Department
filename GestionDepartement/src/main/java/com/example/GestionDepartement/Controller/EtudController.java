package com.example.GestionDepartement.Controller;

import com.example.GestionDepartement.Entities.Etudiant;
import com.example.GestionDepartement.Services.serviceEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller


public class EtudController {
    @Autowired
    private serviceEtudiant etudiantService;

    @GetMapping("/ajouterEtudiant")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "ajouterEtudiant";
    }

    @PostMapping("/ajouterEtudiant")
    public String ajouterEtudiant(@ModelAttribute Etudiant etudiant, RedirectAttributes redirectAttributes) {
        etudiantService.addEtudiant(etudiant);
        redirectAttributes.addFlashAttribute("message", "Étudiant ajouté avec succès!");
        return "redirect:/listeEtudiants";
    }

    @GetMapping("/listeEtudiants")
    public String afficherListeEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        return "listeEtudiants";
    }

}
