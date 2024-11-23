package pro.sky.courseworkUsingSpring.service;

import org.springframework.stereotype.Service;
import pro.sky.courseworkUsingSpring.model.Employee;
import pro.sky.courseworkUsingSpring.exception.EmployeeAlreadyAddedException;
import pro.sky.courseworkUsingSpring.exception.EmployeeNotFoundException;
import pro.sky.courseworkUsingSpring.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int maxEmployees = 8;

    private Map<String, Employee> employees = new HashMap<>(Map.of(
            "Владимир" + "Машков",
            new Employee("Владимир", "Машков", 100000, 2),
            "Константин" + "Хабенский",
            new Employee("Константин", "Хабенский", 120000, 1),
            "Елена" + "Яковлева",
            new Employee("Елена", "Яковлева", 110000, 2),
            "Игорь" + "Петренко",
            new Employee("Игорь", "Петренко", 105000, 2)
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {

        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);

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