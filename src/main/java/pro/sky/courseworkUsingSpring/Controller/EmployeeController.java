package pro.sky.courseworkUsingSpring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseworkUsingSpring.EmployeeServiceImpl;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeNotFoundException;
import pro.sky.courseworkUsingSpring.Exceptions.EmployeeStorageIsFullException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeServiceImpl.addEmployee(firstName, lastName);
        } catch (EmployeeStorageIsFullException e) {
            return "";
        } catch (EmployeeAlreadyAddedException e) {
            return "";
        }
        return "\"firstName\": \"Ivan\", \"lastName\": \"Ivanov\"";
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeServiceImpl.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return "";
        }
        return "\"firstName\": \"Ivan\", \"lastName\": \"Ivanov\"";
    }

    @GetMapping(path = "find")
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeServiceImpl.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return "";
        }
        return "\"firstName\": \"Ivan\", \"lastName\": \"Ivanov\"";
    }
}
