package Application.controller;

import Application.model.User;
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
        List<User> users = userService.findAll();
        model.addAttribute("userRequests", users);
        return "registration";
    }

    @PostMapping("/registration")
    public String getFromRegistrationPage(HttpServletRequest request, Model model) {
        if (!request.getParameter("password").equals(request.getParameter("matchingPassword"))) {
            System.out.println("passwords are not matching");
        } else if (emailExist(request.getParameter("email"))) {
            System.out.println("this email already exists");
        } else {
            User user = new User(request.getParameter("firstName"), request.getParameter("lastName")
                    , request.getParameter("password"), request.getParameter("email"));
            request.getParameter("email");

            try{
                userService.save(user);
            }catch (org.springframework.transaction.TransactionSystemException e){
                System.out.println( e.getClass().getCanonicalName());
                model.addAttribute("firstNameText", request.getParameter("firstName"));
            }
            model.addAttribute("firstNameText", request.getParameter("firstName"));
            List<User> users = userService.findAll();
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
        List<User> users = userService.findAll();
        model.addAttribute("userRequests", users);
        return "login";
    }*/

    private boolean emailExist(String email) {
        User user = userService.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
