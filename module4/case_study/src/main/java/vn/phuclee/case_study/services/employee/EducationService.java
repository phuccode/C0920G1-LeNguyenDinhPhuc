package vn.phuclee.case_study.services.employee;

import vn.phuclee.case_study.model.EducationDegree;

import java.util.List;

public interface EducationService {
    List<EducationDegree> findAll();
}
