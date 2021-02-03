package vn.phuclee.case_study.repository.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.phuclee.case_study.model.Customer;
import vn.phuclee.case_study.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findByEmployeeNameContaining(String searchString, Pageable pageable);
}
