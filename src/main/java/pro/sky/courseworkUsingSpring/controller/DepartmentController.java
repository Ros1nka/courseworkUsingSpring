package pro.sky.courseworkUsingSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseworkUsingSpring.model.Employee;
import pro.sky.courseworkUsingSpring.service.DepartmentService;


@RestController
@RequestMapping("departments")
public class DepartmentController {
    private final  DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee minSalaryDepartment(@RequestParam int departmentId) {
        return minSalaryDepartment(departmentId);
    }
}
