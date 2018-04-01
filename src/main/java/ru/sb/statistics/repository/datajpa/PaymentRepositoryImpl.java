package ru.sb.statistics.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sb.statistics.model.Payment;
import ru.sb.statistics.repository.PaymentRepository;
import ru.sb.statistics.to.PaymentTo;

import java.time.LocalDate;
import java.util.List;


@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
    @Autowired
    PaymentCrudRepository repository;

    @Override
    public Payment save(Payment entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Payment get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Payment> getByMonthAndYear(int month, int year) {
        return repository.getByMonthAndYear(month, year);
    }

    @Override
    public List<PaymentTo> getAggregateSum(int year, int contractId) {
        return repository.getAggregateSum(year, contractId);
    }

    @Override
    public List<Payment> getByCurrentMonthAndYear() {
        int month = LocalDate.now().getMonth().getValue();
        int year = LocalDate.now().getYear();
        if (month == 1){
            month = 12;
            year = year - 1;
        }
        else {
            month = month - 1;
        }
        return getByMonthAndYear(month, year);
    }
}