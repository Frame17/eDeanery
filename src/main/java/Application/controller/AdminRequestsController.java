package Application.controller;

import Application.model.UserRequest;
import Application.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminRequestsController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/admin")
    public String getMainPage(Model model) {
        List<UserRequest> userRequests = requestService.findAll();
        model.addAttribute("userRequests", userRequests);
        return "pageForStaff";
    }

}
