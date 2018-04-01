package ru.sb.statistics.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sb.statistics.model.Queue;
import ru.sb.statistics.model.Role;
import ru.sb.statistics.repository.QueueRepository;
import ru.sb.statistics.repository.RoleRepository;

import java.util.List;

@Repository
public class QueueRepositoryImpl implements QueueRepository {
    @Autowired
    QueueCrudRepository repository;

    @Override
    public Queue save(Queue entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Queue get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Queue> getAll() {
        return repository.findAll();
    }
}