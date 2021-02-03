package vn.phuclee.case_study.services.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.phuclee.case_study.model.Division;
import vn.phuclee.case_study.repository.employee.DivisionRepository;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService{
    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
