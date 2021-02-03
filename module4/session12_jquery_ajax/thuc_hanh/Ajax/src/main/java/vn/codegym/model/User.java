package vn.codegym.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;

    private String nameUser;

    @OneToMany(mappedBy = "userCreate",cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "userFeedback",cascade = CascadeType.ALL)
    private List<Question> questions1;

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions1() {
        return questions1;
    }

    public void setQuestions1(List<Question> questions1) {
        this.questions1 = questions1;
    }
}
