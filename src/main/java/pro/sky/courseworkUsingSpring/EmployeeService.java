package pro.sky.courseworkUsingSpring;
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    boolean findEmployee(String firstName, String lastName);
}
