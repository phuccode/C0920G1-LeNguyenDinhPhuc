package vn.phuclee.case_study.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.phuclee.case_study.model.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
}
