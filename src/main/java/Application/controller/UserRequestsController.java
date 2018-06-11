package Application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserRequestsController {

    @GetMapping("/hello")
    public String getMainPage() {
        return "pageForStudents";
    }
}
