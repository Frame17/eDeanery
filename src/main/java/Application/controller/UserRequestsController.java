package Application.controller;

import Application.model.UserRequest;
import Application.service.UserRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class UserRequestsController {

    @Autowired
    private UserRequestService userRequestService;

    @GetMapping("/hello")
    public String getMainPage(Model model) {
        List<UserRequest> userRequests = userRequestService.findAll();
        model.addAttribute("userRequests", userRequests);
        return "pageForStudents";
    }

    @PostMapping("/hello")
    public String getFromMainPage(HttpServletRequest request, Model model) {
        UserRequest userRequest = new UserRequest(request.getParameter("description"));
        userRequestService.save(userRequest);
        List<UserRequest> userRequests = userRequestService.findAll();
        model.addAttribute("userRequests", userRequests);
        return "pageForStudents";
    }
}
