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

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Превышено максимальное количество сотрудников");
        }
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
		Employee employee = new Employee(firstName, lastName);
        try {
            employees.remove(employee);
        } catch (Exception e) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
		return employee;
		
		//if(!employees.contains(employee)){
		//	throw new EmployeeNotFoundException;
		//}
		//return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
	
    @Override
    public List<Employee> getAllEmployee(){
        return employees;
    }
}
