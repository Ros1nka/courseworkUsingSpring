package pro.sky.courseworkUsingSpring.service;

import pro.sky.courseworkUsingSpring.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalaryDepartment(Integer departmentNumber);

    Employee minSalaryDepartment(Integer departmentNumber);

    List<Employee> getAllEmployeesDepartment(Integer departmentNumber);

    Map<Integer, List<Employee>> getAllEmployees();
}
