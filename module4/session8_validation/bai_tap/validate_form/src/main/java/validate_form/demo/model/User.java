package validate_form.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Vui lòng nhập tên.")
    @Size(min = 5 , max = 45)
    private String firstName;

    @NotEmpty(message = "Vui lòng nhập tên.")
    @Size(min = 5 , max = 45)
    private String lastName;

    @NotEmpty(message = "Vui lòng nhập số điện thoại")
    @Size(max = 10)
    private String phoneNumber;

    @NotEmpty(message = "Vui lòng nhập tuổi")

    private String age;

    @NotEmpty(message = "Vui lòng nhập email")
    @Email
    private String email;

    public User() {
    }

    public User(int id, String firstName,String lastName,String phoneNumber,String age,String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
