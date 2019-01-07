package com.banque.banqueArtifact.compte_courant;


import com.banque.banqueArtifact.client.Client;
import com.banque.banqueArtifact.operation.Operation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "compte_courant")
public class CompteCourant {
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="id_client", insertable = false, updatable = false)
    private Client client;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "compteCourantCredite")
    private List<Operation> OperationListCredite = new ArrayList<Operation>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "compteCourantDebite")
    private List<Operation> OperationListDebite = new ArrayList<Operation>();

    @Id
    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "intitule", nullable = false)
    private String intitule;

    @Column(name = "solde", nullable = true)
    private Float solde;

    @Column(name = "decouvert", nullable = true)
    private Float decouvert;

    @Column(name = "id_client", nullable = false)
    private Long id_client;

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

    public Float getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Float decouvert) {
        this.decouvert = decouvert;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Operation> getOperationListCredite() {
        return OperationListCredite;
    }

    public void setOperationListCredite(List<Operation> operationListCredite) {
        OperationListCredite = operationListCredite;
    }

    public List<Operation> getOperationListDebite() {
        return OperationListDebite;
    }

    public void setOperationListDebite(List<Operation> operationListDebite) {
        OperationListDebite = operationListDebite;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
