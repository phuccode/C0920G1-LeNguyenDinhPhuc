package vn.managebook.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContact;

    @OneToMany(mappedBy = "contact")
    private Set<Book> books;

    public Contact() {
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
