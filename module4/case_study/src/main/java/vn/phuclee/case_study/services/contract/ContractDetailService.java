package vn.phuclee.case_study.services.contract;

import vn.phuclee.case_study.model.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
