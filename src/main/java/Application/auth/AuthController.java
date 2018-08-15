package Application.auth;

import Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        // List<User> users = userService.findAll();
        // model.addAttribute("userRequests", users);
        return "registration";
    }

    @PostMapping("/registration")
    public String postFromRegistrationPage(
            @RequestParam("code") String code,
            @RequestParam("id_token") String idToken,
            @RequestParam("state") UUID state,
            HttpServletRequest request) {

        // Get the expected state value from the session
        HttpSession session = request.getSession();
        UUID expectedState = (UUID) session.getAttribute("expected_state");
        UUID expectedNonce = (UUID) session.getAttribute("expected_nonce");

        // Make sure that the state query parameter returned matches
        // the expected state
        if (state.equals(expectedState)) {
            session.setAttribute("authCode", code);
            session.setAttribute("idToken", idToken);
        } else {
            session.setAttribute("error", "Unexpected state returned from authority.");
        }

        return "registration";
    }


    @GetMapping("/index")
    public String getIndex(Model model, HttpServletRequest request) {
        UUID state = UUID.randomUUID();
        UUID nonce = UUID.randomUUID();

        // Save the state and nonce in the session so we can
        // verify after the auth process redirects back
        HttpSession session = request.getSession();
        session.setAttribute("expected_state", state);
        session.setAttribute("expected_nonce", nonce);

        String loginUrl = AuthHelper.getLoginUrl(state, nonce);
        model.addAttribute("loginUrl", loginUrl);
        // Name of a definition in WEB-INF/defs/pages.xml
        return "index";
    }

    @PostMapping("/index")
    public String postIndex(){
        return "index";
    }
}
