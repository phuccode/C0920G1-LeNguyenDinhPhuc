package case_study.libs;

import case_study.commos.ReadWriteFile;
import case_study.controllers.MainController;
import case_study.models.Employee;

import java.util.Stack;

public class FilingCabinets {
    public static void FilingCabinets(){
        Boolean check = true;
        System.out.println("Input name employee you need to find");
        String checkEmployee = MainController.getScan().nextLine();
        Stack<Employee> employeeStacks = ReadWriteFile.readFileEmployeeStack();
        for (Employee employee : employeeStacks){
            if (employeeStacks.isEmpty()){
                System.out.println("No profile ");
                break;
            } else if (checkEmployee.equals(employee.getEmployeeName())){
                System.out.println("Employee found ....");
                System.out.println(employee.toString());
                check = false;
                break;
            }
        }
        if (check){
            System.out.println("Not found employee :( ");
        }
    }
}
