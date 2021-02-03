package vn.codegym.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuestionType;

    private String nameQuestionType;

    @OneToMany(mappedBy = "idQuestionType",cascade = CascadeType.ALL)
    private List<Question> questions;

    public QuestionType() {
    }

    public int getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(int idQuestionType) {
        this.idQuestionType = idQuestionType;
    }

    public String getNameQuestionType() {
        return nameQuestionType;
    }

    public void setNameQuestionType(String nameQuestionType) {
        this.nameQuestionType = nameQuestionType;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
