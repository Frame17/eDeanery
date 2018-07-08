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
public class AdminRequestsController {

    private final RequestService requestService;

    @Autowired
    public AdminRequestsController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/admin")
    public String getMainPage(Model model) {
        List<UserRequest> userRequests = requestService.findAllByResponseTextNull();
        model.addAttribute("userRequests", userRequests);
        return "pageForStaff";
    }


    @GetMapping("/replyForm")
    public String getReplyForm(@RequestParam(name = "id", required = true) long id, Model model) {
        UserRequest userRequest = requestService.findUserRequestById(id);
        model.addAttribute("userRequest", userRequest);
        return "replyForm";
    }

    @PostMapping("/replyForm")
    public String getFromReplyForm(@RequestParam(name = "id", required = true) long id, HttpServletRequest request, Model model) {
        requestService.updateUserRequestById(id, request.getParameter("answerInput"));
        return "redirect:/admin";
    }
}
