package ru.sb.statistics.controller.rest.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sb.statistics.model.base.AbstractBaseEntity;
import ru.sb.statistics.repository.BaseRepository;

import java.util.List;

public class BaseAjaxController<T extends AbstractBaseEntity> {
    @Autowired
    BaseRepository<T> repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<T> getAll(){
        return repository.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public T get(@PathVariable("id") Integer id) {
        return repository.get(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        repository.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> save(T entity) {
        repository.save(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
