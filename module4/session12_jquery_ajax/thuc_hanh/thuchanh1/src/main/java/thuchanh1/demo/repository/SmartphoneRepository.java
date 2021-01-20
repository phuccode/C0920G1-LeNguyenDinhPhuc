package thuchanh1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thuchanh1.demo.model.Smartphone;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
