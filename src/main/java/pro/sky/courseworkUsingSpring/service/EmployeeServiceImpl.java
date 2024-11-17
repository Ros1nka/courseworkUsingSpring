package pro.sky.courseworkUsingSpring.service;

import org.springframework.stereotype.Service;
import pro.sky.courseworkUsingSpring.model.Employee;
import pro.sky.courseworkUsingSpring.exception.EmployeeAlreadyAddedException;
import pro.sky.courseworkUsingSpring.exception.EmployeeNotFoundException;
import pro.sky.courseworkUsingSpring.exception.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int maxEmployees = 8;

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

        if (employees.containsKey(employeeKey(firstName, lastName))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employeeKey(firstName, lastName), employee);
        return employees.get(employeeKey(firstName, lastName));
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        if (!employees.containsKey(employeeKey(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(employeeKey(firstName, lastName));
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        if (employees.containsKey(employeeKey(firstName, lastName))) {
            return employees.get(employeeKey(firstName, lastName));
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getAllEmployee() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public String employeeKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}