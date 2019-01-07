package com.banque.banqueArtifact.compte_epargne;

import com.banque.banqueArtifact.compte_courant.CompteCourant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteEpargneRepository extends JpaRepository<CompteEpargne, Long> {
}
