package com.banque.banqueArtifact.operation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    @Query("SELECT o.id, o.id_cpt_debite, o.id_cpt_credite, o.montant, cc.id_client FROM Operation o LEFT JOIN CompteCourant cc ON o.id_cpt_credite = cc.numero WHERE id_client =  ?1")
    List<Operation> findByIdClient(Long idClient);
}
