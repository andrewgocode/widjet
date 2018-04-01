package ru.sb.statistics.repository;

import ru.sb.statistics.model.User;
import ru.sb.statistics.to.UserTo;

public interface UserRepository extends BaseRepository<User> {
    User save(UserTo userTo);

    User getByUserName(String name);
}
