package Application.controller;

import Application.model.UserRequest;
import Application.service.RequestService;
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
    private RequestService requestService;

    @GetMapping("/userPage")
    public String getMainPage(Model model) {
        List<UserRequest> userRequests = requestService.findAll();
        model.addAttribute("userRequests", userRequests);
        return "pageForStudents";
    }

    @PostMapping("/userPage")
    public String getFromMainPage(HttpServletRequest request, Model model) {
        UserRequest userRequest = new UserRequest(request.getParameter("description"));
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
        UserRequest userRequest = new UserRequest(request.getParameter("text"));
        requestService.save(userRequest);
        List<UserRequest> userRequests = requestService.findAll();
        model.addAttribute("userRequests", userRequests);
        return "redirect:/userPage";
        //return getMainPage(model);
    }


    /*
    @GetMapping("/add")
    public @ResponseBody String addRequest(@RequestParam String text) {
        UserRequest req = new UserRequest(text);
        requestService.save(req);
        return "Saved\n" + req;
    }
    */
}
