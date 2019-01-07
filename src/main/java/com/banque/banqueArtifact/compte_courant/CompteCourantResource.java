package com.banque.banqueArtifact.compte_courant;

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

    @GetMapping("/comptesC")
    public List<CompteCourant> retrieveAllComptesC() {
        return compteCourantRepository.findAll();
    }

}
