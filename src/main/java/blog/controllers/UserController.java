package blog.controllers;

import blog.forms.LoginForm;
import blog.forms.RegisterForm;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Windows 7 on 26-Apr-17.
 */
@Controller
@RequestMapping(value = "/user")

public class UserController {
    @Autowired
    UserService userService;


    @Autowired
    private NotificationService notificationService;

    // User Registration

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerView(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    // @ResponseBody
    public String register(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult)

        {
            if (bindingResult.hasErrors())
            {
                model.addAttribute("user", user);
                notificationService.addErrorMessage("Please Fill all Fields!");
                return "register";
            }
            // calls user service method Save
            userService.save(user);
            //registration successful
            notificationService.addInfoMessage("Registration Successful");
            return "redirect:/";

        }

    // USER LOGIN

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(Model model)
    {
        LoginForm user = new LoginForm();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    // @ResponseBody
    public String login(Model model, @Valid @ModelAttribute("user") LoginForm user, BindingResult bindingResult,
                        HttpSession session)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("user", user);
            notificationService.addErrorMessage("Please Fill in all Fields!");
            return "login";
        }

        // Login Validation

        if(userService.validateLogin(user)==false)
        {
            model.addAttribute("user", user);

            return "login";

        }

        // starts logged in session
        session.setAttribute("login", true);

        notificationService.addInfoMessage("Welcome");

        return "redirect:/";
    }

    // User Logout

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutView(Model model, HttpSession session)
    {
        session.removeAttribute("login");
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    //   @ResponseBody
    public String logout(Model model, @ModelAttribute("user") User user, HttpSession session)
    {
        // removes logged in session
        session.removeAttribute("login");
        return "redirect:/user/login";
    }

}







