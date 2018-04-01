package ru.sb.statistics.to;

public class PaymentTo {
    public Integer month;

    public Integer year;

    public Long sum;

    public String contractName;

    public PaymentTo(Integer month, Integer year, String contractName, Long sum) {
        this.month = month;
        this.year = year;
        this.contractName = contractName;
        this.sum = sum;
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

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
}
