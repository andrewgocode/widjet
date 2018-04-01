package ru.sb.statistics.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sb.statistics.model.User;
import ru.sb.statistics.repository.UserRepository;
import ru.sb.statistics.security.Authorization;
import ru.sb.statistics.to.UserTo;

import java.util.List;

@Repository(value = "security")
public class UserRepositoryImpl implements UserRepository, UserDetailsService {
    @Autowired
    UserCrudRepository repository;

    @Autowired
    RoleCrudRepository roleCrudRepository;
    
    @Transactional
    @Override
    public User save(UserTo userTo) {
        User user = new User(
                userTo.getId(),
                userTo.getName(),
                roleCrudRepository.getOne(userTo.getRole()),
                userTo.getPassword(),
                userTo.getIrpsId()
        );

        return repository.save(user);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getByUserName(String name) {
        return DataAccessUtils.singleResult(repository.getUseByName(name));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = get(Integer.parseInt(s));
        if (user == null){
            throw new UsernameNotFoundException("пользователь " + s + " не найден.");
        }
        return new Authorization(user);
    }
}
