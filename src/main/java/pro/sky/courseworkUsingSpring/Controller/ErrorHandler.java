package pro.sky.courseworkUsingSpring.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ErrorHandler {

//    @ExceptionHandler({EmployeeNotFoundException.class})
//    public void error(Exception e, HttpServletResponse response) throws IOException {
//        response.setStatus(404);
//        response.getWriter().println("Error: " +e.getMessage());
//    }
}
