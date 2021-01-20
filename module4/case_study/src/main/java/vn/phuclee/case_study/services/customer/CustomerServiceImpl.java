package vn.phuclee.case_study.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.phuclee.case_study.model.Customer;
import vn.phuclee.case_study.repository.customer.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findByInputText(String inputSearch, Pageable pageable) {
        return customerRepository.findByName(inputSearch, pageable);
    }

    @Override
    public Page<Customer> search(String searchName, Pageable pageable) {
        return customerRepository.findByCustomerNameContaining(searchName, pageable);
    }
}
