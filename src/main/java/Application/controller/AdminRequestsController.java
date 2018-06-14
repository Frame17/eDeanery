package Application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminRequestsController {

    @GetMapping("/admin")
    public String getMainPage(Model model) {
        return "pageForAdmins";
    }

}
