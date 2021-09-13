package cookingguide.controllers;

import cookingguide.models.User;
import cookingguide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = {"/register"})
    public String showRegisterPage() {
        return "registration";
    }


    @RequestMapping("/registerNew")
    public String registerNewUser(@RequestParam("fullname") String userFullName,
                                  @RequestParam("location") String userlocation,
                                  @RequestParam("email") String userEmail,
                                  @RequestParam("password") String userPassword,
                                  @RequestParam("gender") String gender){
        User user = new User(userFullName, userEmail, passwordEncoder.encode(userPassword), userlocation, gender);
        System.out.println("I am here...");
        userService.saveUser(user);
        return "redirect:/login";
    }
}
