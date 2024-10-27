package pro.sky.courseworkUsingSpring;

import org.springframework.stereotype.Service;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeNotFoundException;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();
    final int maxEmployees = 10;

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Превышено максимальное количество сотрудников");
        }
        Employee employee = new Employee(firstName, lastName);

        if (findEmployee(firstName, lastName)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employees.add(employee);
        return employee;
    }

    public void removeEmployee(String firstName, String lastName) {
        try {
            findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public boolean findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return true;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
}
