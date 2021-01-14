package validate_form.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import validate_form.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
