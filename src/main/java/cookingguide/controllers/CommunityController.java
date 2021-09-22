package cookingguide.controllers;

import cookingguide.models.User;
import cookingguide.services.RecipeService;
import cookingguide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class CommunityController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/community")
    public String showCommunity(Model model){

        List<User> users  = userService.findAllUsers();
        model.addAttribute("allUsers", users);
        for (User user : users){
            int userRecipeSize = recipeService.getRecipeCountByUsername(user.getUsername());
            user.setRecipeCount(userRecipeSize);
        }

        return "community";
    }

}
