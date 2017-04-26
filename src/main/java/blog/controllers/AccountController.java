package blog.controllers;

/**
 * Created by Windows 7 on 20-Apr-17.
 */

import blog.forms.LoginForm;
import blog.services.LoginService;
import blog.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class AccountController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/users/login")
    public String showLoginForm(LoginForm loginForm) {
        return "users/login";
    }

    @RequestMapping(value = "/users/login",
            method = RequestMethod.POST)
    public String showLoginForm(
            @Valid LoginForm loginForm,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            notificationService.addErrorMessage(
                    "Please fill all fields");
            return "users/login";
        }

        if (! loginService.authentice(loginForm.getUsername(),
                loginForm.getPassword())) {
            notificationService.addErrorMessage("Invalid login");
            return "users/login";
        }

        // Login successful
        notificationService.addInfoMessage("Welcome");
        return "redirect:/";
    }
}
