package vn.phuclee.case_study.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.phuclee.case_study.model.CustomerType;
import vn.phuclee.case_study.repository.customer.CustomerTypeRepository;

import java.util.List;

@Service
public class CustomerTypeImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
