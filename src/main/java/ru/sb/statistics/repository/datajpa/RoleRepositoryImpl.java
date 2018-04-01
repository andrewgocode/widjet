package ru.sb.statistics.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sb.statistics.model.Role;
import ru.sb.statistics.repository.RoleRepository;

import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @Autowired
    RoleCrudRepository repository;
    
    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Role get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }


}
