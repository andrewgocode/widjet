package ru.sb.statistics.repository.datajpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.sb.statistics.model.Contract;


public interface ContractCrudRepository extends JpaRepository<Contract, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Contract c WHERE c.id=:id")
    int delete (@Param("id") int id);
}
