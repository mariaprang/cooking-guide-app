package cookingguide.controllers;

import cookingguide.models.Ingredient;
import cookingguide.models.Recipe;
import cookingguide.services.IngredientService;
import cookingguide.services.RecipeService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PathVariableRecipesController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    IngredientService ingredientService;

//    @GetMapping("/pathvars")
//    public String start(Model model){
//        List<Recipe> recipes = new ArrayList<Recipe>();
//        recipes.add(new Recipe(1,"Bibimbap", 2, 1000, "Korean Dish With Beef And Veggies","https://media.istockphoto.com/photos/bi-bim-bap-picture-id183752521?k=6&m=183752521&s=612x612&w=0&h=GfrqG2gYZbmBbUpETOCAzgDz2SttMP2em5EztLB6mF4="));
//        recipes.add((new Recipe(2,"Steak", 1, 300, "Juicy american style steak","https://pixabay.com/get/g9175fcf554b250869089399151359deeefac9ffdbf9bd46a438a00c0af14e766a1eb5acc522291956dfe15ea67305701_640.jpg")));
//        model.addAttribute("recipes", recipes);
//        return "pathvariables/index";
//
//    }

    @GetMapping("getRecipeById/{id}")
    public String singlePathVariable(@PathVariable("id") int id, Model model){
     Recipe recipe = recipeService.getRecipeById(id);
     List<Ingredient> ingredients = ingredientService.getIngredientForRecipe(recipe);
     model.addAttribute("recipe", recipe);
     model.addAttribute("ingredients", ingredients);

        return "view-details-recipe";

    }
}
