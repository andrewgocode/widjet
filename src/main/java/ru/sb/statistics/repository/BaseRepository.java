package ru.sb.statistics.repository;


import ru.sb.statistics.model.Contract;
import ru.sb.statistics.model.base.AbstractBaseEntity;

import java.util.List;

public interface BaseRepository<T extends AbstractBaseEntity> {
    T save(T entity);

    boolean delete(int id);

    T get(int id);

    List<T> getAll();
}
