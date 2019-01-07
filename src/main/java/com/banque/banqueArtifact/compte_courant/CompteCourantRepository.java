package com.banque.banqueArtifact.compte_courant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteCourantRepository extends JpaRepository<CompteCourant, Long> {

}
