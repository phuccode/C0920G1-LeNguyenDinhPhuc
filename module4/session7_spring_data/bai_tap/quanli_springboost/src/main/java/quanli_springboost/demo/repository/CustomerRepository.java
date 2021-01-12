package quanli_springboost.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import quanli_springboost.demo.model.Customer;
import quanli_springboost.demo.model.Province;
@org.springframework.stereotype.Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
