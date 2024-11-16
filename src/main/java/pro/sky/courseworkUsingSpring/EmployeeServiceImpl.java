package pro.sky.courseworkUsingSpring;

import org.springframework.stereotype.Service;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeNotFoundException;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int maxEmployees = 5;

    Map<String, Employee> employees = new HashMap<>(Map.of(
            "Владимир" + "Машков",
            new Employee("Владимир", "Машков"),
            "Константин" + "Хабенский",
            new Employee("Константин", "Хабенский"),
            "Елена" + "Яковлева",
            new Employee("Елена", "Яковлева"),
            "Игорь" + "Петренко",
            new Employee("Игорь", "Петренко")
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }
}