package Application.controller;

import Application.model.UserDataTransfer;
import Application.model.UserRequest;
import Application.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Controller
@PasswordMatches
public class UserRequestsController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/hello")
    public String getMainPage(Model model) {
        List<UserRequest> userRequests = requestService.findAll();
        model.addAttribute("userRequests", userRequests);
        UserDataTransfer userDto = new UserDataTransfer();
        model.addAttribute("user", userDto);
        return "pageForStudents";
    }

    @PostMapping("/hello")
    public String getFromMainPage(HttpServletRequest request, Model model) {
        UserRequest userRequest = new UserRequest(request.getParameter("description"));
        requestService.save(userRequest);
        List<UserRequest> userRequests = requestService.findAll();
        model.addAttribute("userRequests", userRequests);
        return "pageForStudents";
    }

}


@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
@interface PasswordMatches {
    String message() default "Passwords don't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDataTransfer user = (UserDataTransfer) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}