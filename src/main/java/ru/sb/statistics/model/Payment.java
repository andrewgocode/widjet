package ru.sb.statistics.model;

import org.springframework.format.annotation.DateTimeFormat;
import ru.sb.statistics.model.base.AbstractBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "main_statistic")
public class Payment extends AbstractBaseEntity {
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @Column(name = "sum")
    private Long sum;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "potential_sum")
    private Long potential_sum;

    @Column(name = "potential_quantity")
    private Long potential_quantity;

    @Column(name = "diff_sum")
    private Long diff_sum;

    @Column(name = "diff_quantity")
    private Long diff_quantity;

    @Column(name = "month")
    private Integer month;

    @Column(name = "year")
    private Integer year;

    public Payment(){ }

    public Payment(Integer id, Contract contract, Long sum, Long quantity, Long potential_sum, Long potential_quantity, Long diff_sum, Long diff_quantity, Integer month, Integer year) {
        super(id);
        this.contract = contract;
        this.sum = sum;
        this.quantity = quantity;
        this.potential_sum = potential_sum;
        this.potential_quantity = potential_quantity;
        this.diff_sum = diff_sum;
        this.diff_quantity = diff_quantity;
        this.month = month;
        this.year = year;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPotential_sum() {
        return potential_sum;
    }

    public void setPotential_sum(Long potential_sum) {
        this.potential_sum = potential_sum;
    }

    public Long getPotential_quantity() {
        return potential_quantity;
    }

    public void setPotential_quantity(Long potential_quantity) {
        this.potential_quantity = potential_quantity;
    }

    public Long getDiff_sum() {
        return diff_sum;
    }

    public void setDiff_sum(Long diff_sum) {
        this.diff_sum = diff_sum;
    }

    public Long getDiff_quantity() {
        return diff_quantity;
    }

    public void setDiff_quantity(Long diff_quantity) {
        this.diff_quantity = diff_quantity;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
