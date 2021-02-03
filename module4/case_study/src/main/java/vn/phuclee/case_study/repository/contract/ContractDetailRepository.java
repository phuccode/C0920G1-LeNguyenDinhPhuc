package vn.phuclee.case_study.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.phuclee.case_study.model.ContractDetail;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
}
