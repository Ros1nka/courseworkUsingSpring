package pro.sky.courseworkUsingSpring.service;

import pro.sky.courseworkUsingSpring.model.Employee;

public interface DepartmentService {
    Employee maxSalaryDepartment(int departmentNumber);

    Employee minSalaryDepartment(int departmentNumber);

    void printEmployeesDeportment(int departmentNumber);

    void getAllEmployees();
}
