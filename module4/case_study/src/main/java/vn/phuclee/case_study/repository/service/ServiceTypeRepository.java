package vn.phuclee.case_study.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.phuclee.case_study.model.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
