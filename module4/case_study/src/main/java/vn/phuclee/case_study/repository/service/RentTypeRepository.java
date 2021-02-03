package vn.phuclee.case_study.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.phuclee.case_study.model.RentType;

public interface RentTypeRepository extends JpaRepository<RentType , Integer> {
}
