package pro.sky.courseworkUsingSpring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseworkUsingSpring.Employee;
import pro.sky.courseworkUsingSpring.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstname") String firstName,
                                @RequestParam("lastname") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstname") String firstName,
                                   @RequestParam("lastname") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "find")
    public Employee findEmployee(@RequestParam("firstname") String firstname,
                                 @RequestParam("lastname") String lastName) {
        return employeeService.findEmployee(firstname, lastName);
    }

    @GetMapping(path = "getall")
    public Collection getAllEmployees() {
        return employeeService.getAllEmployee();
    }
}