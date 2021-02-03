package vn.phuclee.case_study.services.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.phuclee.case_study.model.Contract;
import vn.phuclee.case_study.repository.contract.ContractRepository;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
