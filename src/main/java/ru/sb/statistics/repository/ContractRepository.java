package ru.sb.statistics.repository;


import ru.sb.statistics.model.Contract;
import ru.sb.statistics.to.ContractTo;

public interface ContractRepository extends BaseRepository<Contract> {
    Contract save(ContractTo contract);
}
