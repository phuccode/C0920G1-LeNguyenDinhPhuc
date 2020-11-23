package case_study.libs;

import case_study.commos.ReadWriteFile;
import case_study.controllers.MainController;
import case_study.models.Employee;

import java.util.Stack;

public class FilingCabinets {
    public static void FilingCabinets(){
        Boolean check = true;
        System.out.println("Nhập tên nhân viên cần tìm!");
        String checkEmployee = MainController.getScan().nextLine();
        Stack<Employee> employeeStacks = ReadWriteFile.readFileEmployeeStack();
        for (Employee employee : employeeStacks){
            if (employeeStacks.isEmpty()){
                System.out.println("Không có hồ sơ nào trong stack ");
                break;
            } else if (checkEmployee.equals(employee.getEmployeeName())){
                System.out.println("Tìm thấy nhân viên trong stack");
                System.out.println(employee.toString());
                check = false;
                break;
            }
        }
        if (check){
            System.out.println("Không tìm thấy nhân viên trong danh sách!");
        }
    }
}
