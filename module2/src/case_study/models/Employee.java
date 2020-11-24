package case_study.models;

public class Employee {
    String employeeName;
    String birthday;
    String address;

    public Employee(String employeeName, String birthday, String address) {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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
                "Address: " + address + "\n";
    }
}
