package vn.phuclee.case_study.services.contract;

import vn.phuclee.case_study.model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    void save(Contract contract);
}
