package on_tap_2;

public class ListPhone {
    int id;
    String name;
    String numPhone;
    String address;
    String email;

    public ListPhone(int id, String name, String numPhone, String address, String email) {
        this.id = id;
        this.name = name;
        this.numPhone = numPhone;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String showInfo(){
        System.out.println(toString());
        return toString();
    }

    @Override
    public String toString() {
        return "ListPhone " + "\n" +
                "id= " + id + "\n" +
                "name= " + name +"\n" +
                "numPhone= " + numPhone + "\n" +
                "address= " + address + "\n" +
                "email= " + email + "\n";
    }
}
