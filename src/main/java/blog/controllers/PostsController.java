package blog.controllers;

import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public String createView(Model model, HttpSession session)
    {
        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }
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

    @RequestMapping(value = "/update/{post}", method = RequestMethod.GET)

    public String updateView(Model model, @PathVariable Post post)
    {
        model.addAttribute("post", post);

        return "update";

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)

    public String update(@ModelAttribute("post") Post post)
    {
        postService.create(post);

        return "redirect:/user/postedit";
    }

    @RequestMapping (value = "/delete/{post}", method = RequestMethod.GET)

    public String delete(@PathVariable Post post)
    {

        postService.delete(post);

        return "redirect:/user/postedit";

    }

    @RequestMapping(value = "/postedit", method = RequestMethod.GET)

       public String edit(Model model)
    {
        List<Post> posts = postService.findAll();

        model.addAttribute("posts", posts);

        return "postedit";

    }









}
