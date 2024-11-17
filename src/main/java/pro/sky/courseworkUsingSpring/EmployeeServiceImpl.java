package pro.sky.courseworkUsingSpring;

import org.springframework.stereotype.Service;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeNotFoundException;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeStorageIsFullException;

import java.util.Collection;
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
        String employeeKey = firstName + lastName;

        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employeeKey, employee);
        return employees.get(employeeKey);
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String employeeKey = firstName + lastName;

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(employeeKey);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String employeeKey = firstName + lastName;

        if (employees.containsKey(employeeKey)) {
            return employees.get(employeeKey);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getAllEmployee() {
        return (employees.values());
    }
}