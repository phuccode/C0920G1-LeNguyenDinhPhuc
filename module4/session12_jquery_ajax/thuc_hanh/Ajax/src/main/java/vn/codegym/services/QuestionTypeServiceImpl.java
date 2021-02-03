package vn.codegym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.QuestionType;
import vn.codegym.repository.QuestionTypeRepository;

import java.util.List;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService{
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
