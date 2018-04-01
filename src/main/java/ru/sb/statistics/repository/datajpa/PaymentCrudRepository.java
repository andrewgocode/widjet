package ru.sb.statistics.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.sb.statistics.model.Payment;
import ru.sb.statistics.to.PaymentTo;

import java.util.List;

public interface PaymentCrudRepository extends JpaRepository<Payment, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Payment p WHERE p.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT p FROM Payment p WHERE p.month=:month AND p.year=:year")
    List<Payment> getByMonthAndYear(@Param("month") int month, @Param("year") int year);

    @Query("SELECT new ru.sb.statistics.to.PaymentTo(p.month, p.year, p.contract.name, SUM(p.sum)) FROM Payment p WHERE p.year=:year AND p.contract.id=:contractId GROUP BY p.month, p.year, p.contract.name")
    List<PaymentTo> getAggregateSum(@Param("year") int year, @Param("contractId") int contractId);
}
