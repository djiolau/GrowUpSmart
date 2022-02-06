package project.growupsmart.sources.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.growupsmart.sources.model.User;
import project.growupsmart.sources.repository.UserRepository;
import project.growupsmart.sources.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private UserRepository userRepository;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/users")
    public String showUsersPage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("usersInView", users);
        return "index";
    }


}
