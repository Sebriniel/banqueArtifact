package com.banque.banqueArtifact.compte_epargne;

import com.banque.banqueArtifact.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "compte_epargne")
public class CompteEpargne {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_client", insertable = false, updatable = false)
    private Client client;

    @Id
    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "intitule", nullable = false)
    private String intitule;

    @Column(name = "solde", nullable = false)
    private Float solde;

    @Column(name = "taux_interets", nullable = false)
    private Float taux_interets;

    @Column(name = "id_client", nullable = false)
    private Long id_client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

    public Float getTaux_interets() {
        return taux_interets;
    }

    public void setTaux_interets(Float taux_interets) {
        this.taux_interets = taux_interets;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
