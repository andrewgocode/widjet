package ru.sb.statistics.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sb.statistics.model.Contract;
import ru.sb.statistics.repository.ContractRepository;
import ru.sb.statistics.to.ContractTo;

import java.util.List;

@Repository
public class ContractRepositoryImpl implements ContractRepository {
    @Autowired
    ContractCrudRepository repository;

    @Autowired
    UserCrudRepository userCrudRepository;

    @Override
    @Transactional
    public Contract save(ContractTo contractTo) {
        Contract contract = new Contract(
                contractTo.getId(),
                contractTo.getName(),
                contractTo.getInn(),
                contractTo.getEpsIds(),
                contractTo.getEpsIdIn(),
                contractTo.getQuantityEpsId(),
                contractTo.getSum(),
                contractTo.getQuantity(),
                contractTo.getReestrMask(),
                userCrudRepository.getOne(contractTo.getUser())
        );

        return repository.save(contract);
    }

    @Override
    public Contract save(Contract contract) {
        return repository.save(contract);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Contract get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Contract> getAll() {
        return repository.findAll();
    }
}
