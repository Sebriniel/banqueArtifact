package com.banque.banqueArtifact.compte_epargne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompteEpargneResource {
    @Autowired
    private CompteEpargneRepository compteEpargneRepository;

    @GetMapping("/comptesE")
    public List<CompteEpargne> retrieveAllComptesE() {
        return compteEpargneRepository.findAll();
    }
}
