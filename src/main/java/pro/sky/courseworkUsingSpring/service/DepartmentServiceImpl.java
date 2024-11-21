package pro.sky.courseworkUsingSpring.service;

import org.springframework.stereotype.Service;
import pro.sky.courseworkUsingSpring.model.Employee;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalaryDepartment(int departmentNumber) {
        double max = Double.MIN_VALUE;
        Employee maxSalaryInDep = null;

        employeeService.employees.

        employeeService.employees.forEach(e -> e.getSalary );

        for (Employee employee : employees) {
            if (employee != null && departmentNumber == employee.getDepartment() && max < employee.getSalary()) {
                max = employee.getSalary();
                maxSalaryInDep = employee;
            }
        }
        return maxSalaryInDep;
    }

    @Override
    public Employee minSalaryDepartment(int departmentNumber) {

        double min = Double.MAX_VALUE;
        Employee minSalaryInDep = null;

        for (Employee employee : employees) {
            if (employee != null && departmentNumber == employee.getDepartment() && min > employee.getSalary()) {
                min = employee.getSalary();
                minSalaryInDep = employee;
            }
        }
        return minSalaryInDep;
    }

    @Override
    public void printEmployeesDeportment(int departmentNumber) {
        System.out.println("Сотрудники отдела №" + departmentNumber + ":");

        for (Employee employee : employees) {
            if (employee != null && departmentNumber == employee.getDepartment()) {
                System.out.printf("    " + employee.getLastName() +
                        " " + employee.getFirstName() + ", ЗП= %.2f%n", employee.getSalary());
            }
        }
        System.out.println();
    }

    @Override
    public void getAllEmployees() {

    }
}