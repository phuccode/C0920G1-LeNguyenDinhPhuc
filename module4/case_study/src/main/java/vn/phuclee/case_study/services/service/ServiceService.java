package vn.phuclee.case_study.services.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.phuclee.case_study.model.Service;

import java.util.List;

public interface ServiceService  {
    Page<Service> findAll(Pageable pageable);
    List<Service> findAll();
    void save(Service service);
    void update(Service service);
    void delete(String id);
    Service findById(String id);
    Page<Service> search(String searchName, Pageable pageable);
}
