package com.banque.banqueArtifact.client;

import com.banque.banqueArtifact.compte_courant.CompteCourant;
import com.banque.banqueArtifact.compte_epargne.CompteEpargne;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "client")
    private CompteCourant compteCourant;

    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "client")
    private List<CompteEpargne> compteEpargneList = new ArrayList<CompteEpargne>();

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String fullName) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String fullName) {
        this.prenom = prenom;
    }

    public CompteCourant getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(CompteCourant compteCourant) {
        this.compteCourant = compteCourant;
    }

    public List<CompteEpargne> getCompteEpargneList() {
        return compteEpargneList;
    }

    public void setCompteEpargneList(List<CompteEpargne> compteEpargneList) {
        this.compteEpargneList = compteEpargneList;
    }
}
