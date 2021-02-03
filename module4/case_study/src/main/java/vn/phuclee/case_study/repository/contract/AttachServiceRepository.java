package vn.phuclee.case_study.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.phuclee.case_study.model.AttachService;

public interface AttachServiceRepository extends JpaRepository<AttachService, Integer> {
}
