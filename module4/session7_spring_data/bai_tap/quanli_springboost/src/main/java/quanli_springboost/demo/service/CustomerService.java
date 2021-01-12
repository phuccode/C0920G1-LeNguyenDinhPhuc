package quanli_springboost.demo.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import quanli_springboost.demo.model.Customer;
import quanli_springboost.demo.model.Province;
@Service
public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
