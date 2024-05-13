package com.example.GestionDepartement.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date jourCours;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime heureCours;
    @ManyToOne
    private Etudiant etudiant;
    @Enumerated(EnumType.STRING)
    private Abscentisme abscentisme;
}
