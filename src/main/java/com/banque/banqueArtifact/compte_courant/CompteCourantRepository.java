package com.banque.banqueArtifact.compte_courant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteCourantRepository extends JpaRepository<CompteCourant, Long> {
    @Query("SELECT solde FROM CompteCourant WHERE numero = ?1")
    Float retrieveAmount(Long idCompte);
}
