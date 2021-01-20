package vn.phuclee.case_study.services.customer;

import org.springframework.stereotype.Service;
import vn.phuclee.case_study.model.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
}
