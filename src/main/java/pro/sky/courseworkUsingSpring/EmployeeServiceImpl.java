package pro.sky.courseworkUsingSpring;

import org.springframework.stereotype.Service;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeNotFoundException;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int maxEmployees = 5;
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Владимир", "Машков"),
            new Employee("Константин", "Хабенский"),
            new Employee("Елена", "Яковлева"),
            new Employee("Игорь", "Петренко")
    ));
//add?firstname=wqeda&lastname=qwewqeqwe
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
		
		if(!employees.contains(employee)){
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
	public List<Employee> getAllEmployee(){
        return employees;
	}
}