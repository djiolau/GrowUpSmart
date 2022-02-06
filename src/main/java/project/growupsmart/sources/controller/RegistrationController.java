package project.growupsmart.sources.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.growupsmart.sources.model.User;
import project.growupsmart.sources.service.ConfirmationService;
import project.growupsmart.sources.service.UserService;

import javax.validation.Valid;


@Controller
@AllArgsConstructor
public class RegistrationController {
    private ConfirmationService confirmationService;

    private UserService userService;




    @GetMapping("/registration")
    public String registration(Model model) { // !!!!!!!!!
        model.addAttribute("user", new User());
        return "registration";
    }
    @PostMapping("signUpUser")
    public String signUpUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.signUpUser(user);
        return "redirect:/";
    }

    @GetMapping(path = "/registration/confirm")
    public @ResponseBody String confirm(@RequestParam("token") String token){
        return confirmationService.confirmToken(token);
    }

}
