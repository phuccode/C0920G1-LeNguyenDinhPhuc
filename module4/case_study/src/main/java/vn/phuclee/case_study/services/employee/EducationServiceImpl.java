package vn.phuclee.case_study.services.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.phuclee.case_study.model.EducationDegree;
import vn.phuclee.case_study.repository.employee.EducationRepository;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    EducationRepository educationRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationRepository.findAll();
    }
}
