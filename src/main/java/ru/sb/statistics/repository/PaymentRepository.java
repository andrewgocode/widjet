package ru.sb.statistics.repository;

import ru.sb.statistics.model.Payment;
import ru.sb.statistics.to.PaymentTo;

import java.util.List;

public interface PaymentRepository extends BaseRepository<Payment> {
    List<Payment> getByMonthAndYear(int month, int year);

    List<Payment> getByCurrentMonthAndYear();

    List<PaymentTo> getAggregateSum(int year, int contractId);
}
