package com.banque.banqueArtifact.operation;

import com.banque.banqueArtifact.compte_courant.CompteCourant;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name="id_cpt_credite", insertable = false, updatable = false)
    private CompteCourant compteCourantCredite;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name="id_cpt_debite", insertable = false, updatable = false)
    private CompteCourant compteCourantDebite;

    @Column(name = "id_cpt_debite", nullable = true)
    private Long id_cpt_debite;

    @Column(name = "id_cpt_credite", nullable = true)
    private Long id_cpt_credite;

    @Column(name = "montant", nullable = false)
    private Float montant;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_cpt_debite() {
        return id_cpt_debite;
    }

    public void setId_cpt_debite(Long id_cpt_debite) {
        this.id_cpt_debite = id_cpt_debite;
    }

    public Long getId_cpt_credite() {
        return id_cpt_credite;
    }

    public void setId_cpt_credite(Long id_cpt_credite) {
        this.id_cpt_credite = id_cpt_credite;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public CompteCourant getCompteCourantCredite() {
        return compteCourantCredite;
    }

    public void setCompteCourantCredite(CompteCourant compteCourantCredite) {
        this.compteCourantCredite = compteCourantCredite;
    }

    public CompteCourant getCompteCourantDebite() {
        return compteCourantDebite;
    }

    public void setCompteCourantDebite(CompteCourant compteCourantDebite) {
        this.compteCourantDebite = compteCourantDebite;
    }
}
