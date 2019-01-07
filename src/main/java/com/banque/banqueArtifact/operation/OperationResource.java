package com.banque.banqueArtifact.operation;

import com.banque.banqueArtifact.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
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
        String sql = "SELECT o.id, o.id_cpt_debite, o.id_cpt_credite, o.montant, cc.id_client FROM operation o LEFT JOIN compte_courant cc ON operation.id_cpt_credite = cc.numero WHERE id_client = " + clientId;
        List<Operation> operations = new ArrayList<Operation>();
        List<Map> rows = getJdbcTemplate().queryForList(sql);
    }
}
