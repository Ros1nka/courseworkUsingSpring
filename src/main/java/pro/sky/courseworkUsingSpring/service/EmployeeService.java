package pro.sky.courseworkUsingSpring.service;

import pro.sky.courseworkUsingSpring.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int salary, int department);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployee();

    String employeeKey(String firstName, String lastName);
}