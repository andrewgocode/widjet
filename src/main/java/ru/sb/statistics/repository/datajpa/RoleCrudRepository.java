package ru.sb.statistics.repository.datajpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.sb.statistics.model.Role;
import ru.sb.statistics.model.User;


public interface RoleCrudRepository extends JpaRepository<Role, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Role r WHERE r.id=:id")
    int delete(@Param("id") int id);
}
