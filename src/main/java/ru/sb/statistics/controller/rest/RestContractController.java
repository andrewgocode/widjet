package ru.sb.statistics.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sb.statistics.model.Contract;
import ru.sb.statistics.repository.ContractRepository;
import ru.sb.statistics.to.ContractTo;

import java.util.List;

@RestController
@RequestMapping("/rest/contracts")
public class RestContractController{
    @Autowired
    ContractRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contract> getAll(){
        return repository.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contract get(@PathVariable("id") Integer id) {
        return repository.get(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        repository.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> save(ContractTo entity) {
        repository.save(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
