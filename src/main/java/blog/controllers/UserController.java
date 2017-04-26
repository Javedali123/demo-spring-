package blog.controllers;

import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerView(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
 //   @ResponseBody
    public String register(Model model, @ModelAttribute("user") User user)
    {
        userService.save(user); // calls user service method Save
        //registration successful
        notificationService.addInfoMessage("Welcome");
        return "redirect:/";
    }

}

//"register is successful for"+user.getFullName()+" "+user.getUsername()+" "+user.getPasswordHash();