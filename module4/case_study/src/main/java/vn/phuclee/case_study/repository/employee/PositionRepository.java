package vn.phuclee.case_study.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.phuclee.case_study.model.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
