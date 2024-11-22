package pro.sky.courseworkUsingSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseworkUsingSpring.model.Employee;
import pro.sky.courseworkUsingSpring.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalaryDepartment(@RequestParam Integer departmentId) {

        return departmentService.maxSalaryDepartment(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalaryDepartment(@RequestParam Integer departmentId) {

        return departmentService.minSalaryDepartment(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployeesDepartment(@RequestParam(required = false) Integer departmentId) {

        if (departmentId != null) {
            return departmentService.getAllEmployeesDepartment(departmentId);
        } else
            return departmentService.getAllEmployees();
    }
}
