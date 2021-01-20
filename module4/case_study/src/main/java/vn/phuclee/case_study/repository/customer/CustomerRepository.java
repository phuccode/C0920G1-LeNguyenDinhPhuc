package vn.phuclee.case_study.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.phuclee.case_study.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query("select s from Customer s where s.customerName =:input")
    Page<Customer> findByName(@Param("input") String name, Pageable pageable);

    Page<Customer> findByCustomerNameContaining(String searchString, Pageable pageable);
}
