package vn.phuclee.case_study.repository.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.phuclee.case_study.model.Service;

public interface ServiceRepository extends JpaRepository<Service, String> {
    Page<Service> findByServiceNameContaining(String searchString, Pageable pageable);
}
