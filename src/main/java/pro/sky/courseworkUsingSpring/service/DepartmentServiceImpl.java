package pro.sky.courseworkUsingSpring.service;

import org.springframework.stereotype.Service;
import pro.sky.courseworkUsingSpring.exception.EmployeeNotFoundException;
import pro.sky.courseworkUsingSpring.model.Employee;

import java.util.Comparator;
import java.util.List;
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
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee().stream().toList();
    }
}