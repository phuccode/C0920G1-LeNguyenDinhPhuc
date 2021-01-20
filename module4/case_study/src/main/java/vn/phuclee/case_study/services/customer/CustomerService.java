package vn.phuclee.case_study.services.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.phuclee.case_study.model.Customer;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    void update(Customer customer);
    void delete(String id);
    Customer findById(String id);
    Page<Customer> findByInputText(String inputSearch, Pageable pageable);
    Page<Customer> search(String searchName, Pageable pageable);
}
