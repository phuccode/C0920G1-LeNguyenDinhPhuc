package vn.codegym.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Question;

import java.util.List;

public interface QuestionService {
    Page<Question> findAllPage(Pageable pageable);
    List<Question> findAll();
    void save(Question question);
    void delete(int id);
    Question findById(int id);
    Page<Question> search(String searchName, Pageable pageable);
}
