package ru.sb.statistics.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sb.statistics.controller.rest.base.BaseAjaxController;
import ru.sb.statistics.model.Payment;
import ru.sb.statistics.repository.PaymentRepository;
import ru.sb.statistics.to.PaymentTo;

import java.util.List;

@RestController
@RequestMapping("/rest/payments")
public class RestPaymentController extends BaseAjaxController<Payment> {
    @Autowired
    PaymentRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Payment> getAll(){
        return repository.getByCurrentMonthAndYear();
    }

    @GetMapping(value = "/getByMonthAndYear/{month}/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Payment> getByMonthAndYear(@PathVariable("month") Integer month, @PathVariable("year") Integer year) {
        return repository.getByMonthAndYear(month, year);
    }

    @GetMapping(value = "/getAggregateSum/{year}/{contractId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentTo> getAggregateSum(@PathVariable("year") Integer year, @PathVariable("contractId") Integer contractId) {
        return repository.getAggregateSum(year, contractId);
    }
}
