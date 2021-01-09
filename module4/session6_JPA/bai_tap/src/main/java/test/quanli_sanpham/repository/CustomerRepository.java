package test.quanli_sanpham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.quanli_sanpham.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
