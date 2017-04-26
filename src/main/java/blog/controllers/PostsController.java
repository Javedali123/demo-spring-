package blog.controllers;

import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Windows 7 on 26-Apr-17.
 */

@Controller
@RequestMapping(value = "/user")

public class PostsController {

    @Autowired
    PostService postService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)

    public String createView(Model model)
    {
        Post post = new Post();
        model.addAttribute("post", post);
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)

    public String create(Model model, @ModelAttribute("post") Post post)

    {

        postService.create(post);
        return "redirect:/";
    }




}
