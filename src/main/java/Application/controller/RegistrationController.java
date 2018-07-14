package Application.controller;

import Application.model.Users;
import Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        List<Users> users = userService.findAll();
        model.addAttribute("userRequests", users);
        return "registration";
    }

    @PostMapping("/registration")
    public String getFromRegistrationPage(HttpServletRequest request, Model model) {
        if (!request.getParameter("password").equals(request.getParameter("matchingPassword"))) {
            System.out.println("request = [" + request + "], model = [" + model + "]");
        } else if (emailExist(request.getParameter("email"))) {

        } else {
            Users user = new Users(request.getParameter("firstName"), request.getParameter("lastName")
                    , request.getParameter("password"), request.getParameter("email"));
            userService.save(user);
            List<Users> users = userService.findAll();
            model.addAttribute("users", users);
        }
        return "registration";
    }

    /*@PostMapping("/login")
    public String returnLogin() {
        return "login";

    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        List<Users> users = userService.findAll();
        model.addAttribute("userRequests", users);
        return "login";
    }*/

    private boolean emailExist(String email) {
        Users user = userService.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
