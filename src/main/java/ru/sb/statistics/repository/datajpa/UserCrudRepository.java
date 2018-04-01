package ru.sb.statistics.repository.datajpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.sb.statistics.model.Contract;
import ru.sb.statistics.model.User;
import ru.sb.statistics.to.PaymentTo;

import java.util.List;


public interface UserCrudRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT u FROM User u WHERE u.name=:name")
    List<User> getUseByName(@Param("name") String name);
}
