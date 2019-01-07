package com.banque.banqueArtifact.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientResource {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.GET)
    public Optional<Client> retrieveOneClient(@PathVariable @NotNull Long clientId) {
        return clientRepository.findById(clientId);
    }
}
