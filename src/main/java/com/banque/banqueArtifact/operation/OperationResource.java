package com.banque.banqueArtifact.operation;

import com.banque.banqueArtifact.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class OperationResource {
    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("/operations")
    public List<Operation> retrieveAllOperations() {
        return operationRepository.findAll();
    }

    @RequestMapping(value = "/operations/{clientId}", method = RequestMethod.GET)
    public List<Operation> retrieveAllOperationsByIdClient(@PathVariable @NotNull Long clientId) {
        return operationRepository.findByIdClient(clientId);
    }
}
