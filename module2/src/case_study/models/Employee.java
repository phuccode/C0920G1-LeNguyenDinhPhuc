package case_study.models;

public class Employee {
    String employeeName;
    int birthday;
    String address;

    public Employee(String employeeName, int birthday, String address) {
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.address = address;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee: " + "\n" +
                "Employee Name: " + employeeName + "\n" +
                "Birthday: " + birthday + "\n" +
                "Address: " + address + "\n" ;
    }
}
