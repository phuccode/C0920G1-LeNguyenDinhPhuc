package vn.managebook.demo.model;

import javax.persistence.*;



@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;

    private String bookName;
    private int amountBook;

    public Book(String bookName, int amountBook) {
        this.bookName = bookName;
        this.amountBook = amountBook;
    }

    public Book() {
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public int getIdBook() {
        return idBook;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getAmountBook() {
        return amountBook;
    }

    public void setAmountBook(int amountBook) {
        this.amountBook = amountBook;
    }
}
