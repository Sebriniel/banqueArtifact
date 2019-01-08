package com.banque.banqueArtifact.compte_courant;

import com.banque.banqueArtifact.operation.Operation;
import com.banque.banqueArtifact.operation.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
public class CompteCourantResource {
    @Autowired
    private CompteCourantRepository compteCourantRepository;
    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("/comptesC")
    public List<CompteCourant> retrieveAllComptesC() {
        return compteCourantRepository.findAll();
    }

    @PostMapping(value = "/crediter")
    public void crediter(Long compteEmetteur, Long compteReceveur, Float montant) {

        CompteCourant cce = compteCourantRepository.findById(compteEmetteur).orElse(null);
        CompteCourant ccr = compteCourantRepository.findById(compteReceveur).orElse(null);

        cce.setSolde(cce.getSolde() - montant);
        ccr.setSolde(ccr.getSolde() + montant);

        compteCourantRepository.save(cce);
        compteCourantRepository.save(ccr);

        Operation operation = new Operation();
        operation.setId_cpt_credite(ccr.getNumero());
        operation.setId_cpt_debite(cce.getNumero());
        operation.setMontant(montant);

        operationRepository.save(operation);
    }

    @PostMapping(value = "/debiter")
    public void debiter(Long compteCredite, Long compteDebite, Float montant) {
        CompteCourant ccc = compteCourantRepository.findById(compteCredite).orElse(null);
        CompteCourant ccd = compteCourantRepository.findById(compteDebite).orElse(null);

        ccc.setSolde(ccc.getSolde() + montant);
        ccd.setSolde(ccd.getSolde() - montant);

        Operation operation = new Operation();
        operation.setId_cpt_credite(ccc.getNumero());
        operation.setId_cpt_debite(ccd.getNumero());
        operation.setMontant(montant);

        operationRepository.save(operation);
    }

}
