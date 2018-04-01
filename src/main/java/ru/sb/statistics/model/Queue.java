package ru.sb.statistics.model;

import org.springframework.format.annotation.DateTimeFormat;
import ru.sb.statistics.model.base.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "queue")
public class Queue extends AbstractBaseEntity {
    @Column(name = "date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    @Column(name = "type")
    private Integer type;

    @Column(name = "status")
    private Integer status;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_from")
    private LocalDate dateFrom;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "param")
    private String param;

    public Queue(){

    }

    public Queue(LocalDateTime date, Integer type, Integer status, LocalDate dateFrom, LocalDate dateTo, String param) {
        this.date = date;
        this.type = type;
        this.status = status;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.param = param;
    }

    public Queue(Integer id, LocalDateTime date, Integer type, Integer status, LocalDate dateFrom, LocalDate dateTo, String param) {
        super(id);
        this.date = date;
        this.type = type;
        this.status = status;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.param = param;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}