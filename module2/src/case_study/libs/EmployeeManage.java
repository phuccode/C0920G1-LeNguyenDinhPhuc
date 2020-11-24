package case_study.libs;

import case_study.commos.ReadWriteFile;
import case_study.models.Employee;

import java.util.*;

public class EmployeeManage {
    List<Employee> employeeManageList = new ArrayList<>();
    String employee = "src/case_study/data/Employee.csv";

    public void addEmploy() {
        Employee employee1 = new Employee(inputName(), inputBirthday(), inputAddress());
        employeeManageList.add(employee1);
        ReadWriteFile.writeFile(employee, employee1.getEmployeeName() + "," + employee1.getBirthday()
                + "," + employee1.getAddress());
    }

    public void showInformationEmployee() {
        Map<Integer, Employee> employeeMaps = ReadWriteFile.readFileEmployee();
        for (Map.Entry<Integer, Employee> employees : employeeMaps.entrySet()) {
            System.out.println(employees.toString());
        }
    }

    public static String inputName() {
        System.out.println("Nhập tên nhân viên: ");
        return getScan().nextLine();
    }

    public static String inputBirthday() {
        System.out.println("Nhập tuổi nhân viên: ");
        return getScan().nextLine();
    }

    public static String inputAddress() {
        System.out.println("Nhập địa chỉ nhân viên: ");
        return getScan().nextLine();
    }


    public static Scanner getScan() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}
