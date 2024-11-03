package pro.sky.courseworkUsingSpring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseworkUsingSpring.Employee;
import pro.sky.courseworkUsingSpring.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
//        try {
//            employeeService.addEmployee(firstName, lastName);
//        } catch (EmployeeStorageIsFullException e) {
//            return "";
//        } catch (EmployeeAlreadyAddedException e) {
//           return "";
//        }
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        //try {
        //    employeeServiceImpl.removeEmployee(firstName, lastName);
        //} catch (EmployeeNotFoundException e) {
        //    return "";
        //}
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "find")
    public Employee findEmployee(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastName) {
        //try {
        //    employeeServiceImpl.findEmployee(firstName, lastName);
        //} catch (EmployeeNotFoundException e) {
        //    return "";
        //}
        return employeeService.findEmployee(firstname, lastName);
    }

    @GetMapping(path = "getall")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }
}