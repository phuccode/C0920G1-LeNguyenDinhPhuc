package vn.phuclee.case_study.services.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.phuclee.case_study.model.Position;
import vn.phuclee.case_study.repository.employee.PositionRepository;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
