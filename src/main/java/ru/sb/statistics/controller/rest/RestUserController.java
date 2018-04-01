package ru.sb.statistics.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sb.statistics.model.User;
import ru.sb.statistics.repository.UserRepository;
import ru.sb.statistics.to.UserTo;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class RestUserController{
    @Autowired
    UserRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll(){
        return repository.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") Integer id) {
        return repository.get(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        repository.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> save(UserTo entity) {
        repository.save(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
