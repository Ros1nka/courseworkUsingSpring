package pro.sky.courseworkUsingSpring.service;

import pro.sky.courseworkUsingSpring.model.Employee;

public class DepartmentServiceImpl implements DepartmentService {

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
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
    public Employee maxSalaryDepartment(int departmentNumber) {
        double max = Double.MIN_VALUE;
        Employee maxSalaryInDep = null;

        for (Employee employee : employees) {
            if (employee != null && departmentNumber == employee.getDepartment() && max < employee.getSalary()) {
                max = employee.getSalary();
                maxSalaryInDep = employee;
            }
        }
        return maxSalaryInDep;
    }

    @Override
    public void printEmployeesDeportment(int departmentNumber) {
        System.out.println("Сотрудники отдела №" + departmentNumber + ":");

        for (Employee employee : employees) {
            if (employee != null && departmentNumber == employee.getDepartment()) {
                System.out.printf("    " + employee.getId() + " " + employee.getLastName() + " " + employee.getFirstName() +
                        " " + employee.getPatronymic() + ", ЗП= %.2f%n", employee.getSalary());
            }
        }
        System.out.println();
    }

    @Override
    public void getAllEmployees() {

    }
}