package vn.codegym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Question;
import vn.codegym.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Page<Question> findAllPage(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void delete(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Question findById(int id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Question> search(String searchName, Pageable pageable) {
        return questionRepository.findByTitleContaining(searchName, pageable);
    }
}
