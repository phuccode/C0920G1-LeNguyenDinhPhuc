package case_study.commos;

import case_study.models.Customer;
import case_study.models.Employee;

import java.io.*;
import java.util.*;

public class ReadWriteFile {
    public static void writeFile(String filePath, String line){
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readFile(String filePath){
        List<String[]> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")){
                String[] elementLine = line.split(",");
                list.add(elementLine);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Map<Integer, Employee> readFileEmployee(){
        int count = 1;
        Map<Integer, Employee> employeeMap = new TreeMap<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/case_study/data/Employee.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")){
                String[] elementLine = line.split(",");
                Employee employees = new Employee(elementLine[0], elementLine[1], elementLine[2]);
                employeeMap.put(count,employees);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeMap;
    }

    public static Stack<Employee> readFileEmployeeStack(){
        int count = 1;
        Stack<Employee> employeeStack = new Stack<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/CaseStudy/data/Employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")){
                String[] elementLine = line.split(",");
                Employee employees = new Employee(elementLine[0], elementLine[1], elementLine[2]);
                employeeStack.push(employees);
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeStack;
    }
}
