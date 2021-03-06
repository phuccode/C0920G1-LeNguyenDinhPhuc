package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Page<Question> findByTitleContaining (String searchString, Pageable pageable);
}
