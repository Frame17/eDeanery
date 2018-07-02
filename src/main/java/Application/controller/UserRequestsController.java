package Application.controller;

import Application.model.UserRequest;
import Application.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class UserRequestsController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/userPage")
    public String getMainPage(Model model) {
        List<UserRequest> userRequests = requestService.findAll();
        model.addAttribute("userRequests", userRequests);
        return "pageForStudents";
    }

    @PostMapping("/userPage")
    public String getFromMainPage(HttpServletRequest request, Model model) {

        UserRequest userRequest = new UserRequest(request.getParameter("text"), request.getParameter("requestTopic"));
        requestService.save(userRequest);
        List<UserRequest> userRequests = requestService.findAll();
        model.addAttribute("userRequests", userRequests);
        return "pageForStudents";
    }

    @GetMapping("/add")
    public String getAddRequestPage(Model model) {
        return "addRequestForm";
    }

    @PostMapping("/add")
    public String postFromAddRequestPage(HttpServletRequest request, Model model) {
        UserRequest userRequest = new UserRequest(request.getParameter("text"), request.getParameter("topic"));
        requestService.save(userRequest);
        List<UserRequest> userRequests = requestService.findAll();
        model.addAttribute("userRequests", userRequests);
        return "redirect:/userPage";
    }

    @GetMapping("/viewForm")
    public String getReplyForm(@RequestParam(name = "id", required = true) long id, Model model) {
        UserRequest userRequest = requestService.findUserRequestById(id);
        model.addAttribute("userRequest", userRequest);
        return "viewForm";
    }
}
