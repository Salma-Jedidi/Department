package com.example.GestionDepartement.Entities;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;
    @Enumerated(EnumType.STRING)
    private Reussite reussite;
    private String nomEtudiant;
}
