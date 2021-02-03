package vn.codegym.model;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Question implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuestion;

    @NotNull(message = "input text please")
    @Size(min=5, max = 100, message = "please input 5 - 100 world")
    private String title;

    private String question;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "id_question_type",nullable = false)
    private QuestionType idQuestionType;

    private String dateCreate;

    @ManyToOne
    @JoinColumn(name = "id_create",nullable = false)
    private User userCreate;

    @ManyToOne
    @JoinColumn(name = "id_feedback",nullable = false)
    private User userFeedback;

    @NotEmpty(message = "input text please")
    private String status;

    public Question() {
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(QuestionType idQuestionType) {
        this.idQuestionType = idQuestionType;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public User getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }

    public User getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(User userFeedback) {
        this.userFeedback = userFeedback;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
