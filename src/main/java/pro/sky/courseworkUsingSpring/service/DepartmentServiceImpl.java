package pro.sky.courseworkUsingSpring.service;

import org.springframework.stereotype.Service;
import pro.sky.courseworkUsingSpring.exception.EmployeeNotFoundException;
import pro.sky.courseworkUsingSpring.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalaryDepartment(Integer departmentNumber) {

        return employeeService.getAllEmployee().stream()
                .filter(e -> e.getDepartment() == departmentNumber)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee minSalaryDepartment(Integer departmentNumber) {

        return employeeService.getAllEmployee().stream()
                .filter(e -> e.getDepartment() == departmentNumber)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getAllEmployeesDepartment(Integer departmentNumber) {

        return employeeService.getAllEmployee().stream()
                .filter(e -> e.getDepartment() == departmentNumber)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}