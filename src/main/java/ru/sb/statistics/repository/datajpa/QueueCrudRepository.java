package ru.sb.statistics.repository.datajpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.sb.statistics.model.Contract;
import ru.sb.statistics.model.Queue;


public interface QueueCrudRepository extends JpaRepository<Queue, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Queue q WHERE q.id=:id")
    int delete(@Param("id") int id);
}
