package ru.sb.statistics.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sb.statistics.model.Queue;
import ru.sb.statistics.repository.QueueRepository;
import ru.sb.statistics.to.QueueTo;

import java.util.List;

@RestController
@RequestMapping("/rest/queue")
public class RestQueueController {
    @Autowired
    QueueRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Queue> getAll(){
        return repository.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Queue get(@PathVariable("id") Integer id) {
        return repository.get(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        repository.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> save(QueueTo entity) {
        repository.save(entity.asQueue());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
