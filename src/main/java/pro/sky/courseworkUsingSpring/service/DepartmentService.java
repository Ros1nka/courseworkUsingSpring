package pro.sky.courseworkUsingSpring.service;

import pro.sky.courseworkUsingSpring.model.Employee;

public interface DepartmentService {
    Employee minSalaryDepartment(int departmentNumber);

    Employee maxSalaryDepartment(int departmentNumber);

    void printEmployeesDeportment(int departmentNumber);

    void getAllEmployees();
}
