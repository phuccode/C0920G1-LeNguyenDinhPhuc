package vn.phuclee.case_study.services.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.phuclee.case_study.model.Employee;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAllPage(Pageable pageable);
    List<Employee> findAll();
    void save(Employee employee);
    void delete(int id);
    Employee findById(int id);
    Page<Employee> findByInputText(String inputSearch, Pageable pageable);
}
