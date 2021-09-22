package cookingguide.config;

import cookingguide.models.*;
import cookingguide.repositories.IngredientRepository;
import cookingguide.services.IngredientService;
import cookingguide.services.RecipeService;
import cookingguide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.annotation.PostConstruct;

@Configuration
public class InitialData {


    @Autowired
    RecipeService recipeService;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * PostConstruct method
     */
    @PostConstruct
    public void initializedInfo(){


        Recipe recipe1 = new Recipe("Bibimbap", 2, 1000, "Korean Dish With Beef And Veggies","bibimbap.jpg", "Regional");
        Ingredient ingredient1 = new Ingredient("Beef Steak(s)", 250, UnitOfMeasurements.GR);
        Ingredient ingredient2 = new Ingredient("Rice", 1, UnitOfMeasurements.CUP );
        Ingredient ingredient3 = new Ingredient("Carrot(s)", 1, UnitOfMeasurements.Piece);
        Ingredient ingredient4 = new Ingredient("Zucchini", 1, UnitOfMeasurements.Piece);
        Ingredient ingredient5 = new Ingredient("Mushroom(s)", 50, UnitOfMeasurements.GR );
        Ingredient ingredient6 = new Ingredient("Bean Sprouts", 150, UnitOfMeasurements.GR );
        Ingredient ingredient7 = new Ingredient("Egg(s)", 2, UnitOfMeasurements.Pieces );
        Ingredient ingredient8 = new Ingredient("Soy Sauce", 2, UnitOfMeasurements.TBSP );
        Ingredient ingredient9 = new Ingredient("Sesame Oil", 2, UnitOfMeasurements.TBSP);
        Ingredient ingredient10 = new Ingredient("Onion(s)", 1, UnitOfMeasurements.Piece );
        Ingredient ingredient11 = new Ingredient("Garlic(s)", 2, UnitOfMeasurements.Cloves);
        Ingredient ingredient12 = new Ingredient("Sugar", 1, UnitOfMeasurements.TSP);
        Ingredient ingredient13 = new Ingredient("Garlic(s)", 2, UnitOfMeasurements.Cloves);
        Ingredient ingredient14 = new Ingredient("Pepper", 1.5, UnitOfMeasurements.TSP);
        Ingredient ingredient15 = new Ingredient("Apple(or Korean Pear)", 1, UnitOfMeasurements.Piece);
        Ingredient ingredient16 = new Ingredient("Peach(or Korean Pear)", 1, UnitOfMeasurements.Piece);

        recipe1.getIngredientList().add(ingredient1);
        recipe1.getIngredientList().add(ingredient2);
        recipe1.getIngredientList().add(ingredient3);
        recipe1.getIngredientList().add(ingredient4);
        recipe1.getIngredientList().add(ingredient5);
        recipe1.getIngredientList().add(ingredient6);
        recipe1.getIngredientList().add(ingredient7);
        recipe1.getIngredientList().add(ingredient8);
        recipe1.getIngredientList().add(ingredient9);
        recipe1.getIngredientList().add(ingredient10);
        recipe1.getIngredientList().add(ingredient11);
        recipe1.getIngredientList().add(ingredient12);
        recipe1.getIngredientList().add(ingredient13);
        recipe1.getIngredientList().add(ingredient14);
        recipe1.getIngredientList().add(ingredient15);

        Recipe recipe2 = new Recipe("Steak", 1, 300, "Juicy american style steak","steak.jpg", "Seasonal");
        Ingredient ing1 = new Ingredient("Rib Eye",200, UnitOfMeasurements.GR);
        Ingredient ing2 = new Ingredient("Olive oil",1, UnitOfMeasurements.TBSP);
        Ingredient ing3 = new Ingredient("Salt",1.5, UnitOfMeasurements.TSP);
        Ingredient ing4 = new Ingredient("Pepper",1.5, UnitOfMeasurements.TSP);

        recipe2.getIngredientList().add(ing1);
        recipe2.getIngredientList().add(ing2);
        recipe2.getIngredientList().add(ing3);
        recipe2.getIngredientList().add(ing4);

        Recipe recipe3 = new Recipe("Shakshuka", 2, 250,"Tunisian and Israelian dish","food-ingredient.jpg", "Regional" );
        Ingredient ing_1 = new Ingredient("Eggs",2, UnitOfMeasurements.Pieces);
        Ingredient ing_2 = new Ingredient("Tomato pure",2, UnitOfMeasurements.TBSP);
        Ingredient ing_3 = new Ingredient("Paprika Powder",1.2, UnitOfMeasurements.TSP);
        Ingredient ing_4 = new Ingredient("Salt",1.2, UnitOfMeasurements.TSP);
        Ingredient ing_5 = new Ingredient("Fresh Tomatoes",4, UnitOfMeasurements.Pieces);

        recipe3.getIngredientList().add(ing_1);
        recipe3.getIngredientList().add(ing_2);
        recipe3.getIngredientList().add(ing_3);
        recipe3.getIngredientList().add(ing_4);
        recipe3.getIngredientList().add(ing_5);


        //********************************************************************************************************************************//

        recipeService.saveRecipe(recipe1);
        for(Ingredient ingredient : recipe1.getIngredientList()){
            ingredient.setRecipe(recipe1);
            ingredientRepository.save(ingredient);
        }

        recipeService.saveRecipe(recipe2);
        for(Ingredient ingredient : recipe2.getIngredientList()){
            ingredient.setRecipe(recipe2);
            ingredientRepository.save(ingredient);
        }

        recipeService.saveRecipe(recipe3);
        for (Ingredient ingredient : recipe3.getIngredientList()){
            ingredient.setRecipe(recipe3);
            ingredientRepository.save(ingredient);
        }

//        recipeService.saveRecipe(recipe1);
//        recipeService.saveRecipe(recipe2);
//        recipeService.saveRecipe(recipe3);
//
//        ingredientRepository.save(recipe1.getIngredientList().get(0));
//        ingredientRepository.save(recipe1.getIngredientList().get(1));


        System.out.println(ingredientRepository.findIngredientsByRecipe(recipe1));



        User user = new User("Tom Hanks", "test@gmail.com",
                passwordEncoder.encode("test"), "USA, NY","Male" );
        user.getRecipes().add(recipe1);
        recipe1.setUser(user);
        userService.saveUser(user);

        User user2 = new User("Martha Stewart", "test2@gmail.com",
                passwordEncoder.encode("test2"), "USA, NY","Female" );

        user2.getRecipes().add(recipe2);
        recipe2.setUser(user2);
        userService.saveUser(user2);


        User user3 = new User("Henry Marsch", "test3@gmail.com",
                passwordEncoder.encode("test3"), "USA, NY","Male" );
        user3.setBadge(Badge.INTERMEDIATE);

        user3.getRecipes().add(recipe3);

        userService.saveUser(user3);
        recipe3.setUser(user3);

        User user4 = new User("Anna Johnson", "test4@gmail.com",
                passwordEncoder.encode("test4"), "USA, NY","Female" );

        userService.saveUser(user4);

        User user5 = new User("John Hopkins", "test5@gmail.com",
                passwordEncoder.encode("test5"), "USA, NY","Male" );
        user5.setBadge(Badge.ADVANCED);

        userService.saveUser(user5);

        User user6 = new User("Maria Prangishvili", "test6@gmail.com",
                passwordEncoder.encode("test6"), "USA, NY","Female" );
        userService.saveUser(user6);
    }

}
