package ru.sb.statistics.to;

import org.springframework.format.annotation.DateTimeFormat;
import ru.sb.statistics.model.Queue;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class QueueTo {
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateFrom;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateTo;

    private String param;

    public QueueTo() {
    }

    public QueueTo(LocalDate dateFrom, LocalDate dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Queue asQueue(){
        return new Queue(LocalDateTime.now(), 1, 0, this.dateFrom, this.dateTo, this.param);
    }
}

