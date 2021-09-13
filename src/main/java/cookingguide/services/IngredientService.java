package cookingguide.services;

import cookingguide.models.Ingredient;
import cookingguide.models.Recipe;
import cookingguide.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public Ingredient getIngredientById(int id){
        return ingredientRepository.findById(id);
    }

    public List<Ingredient> getAllIngredients(){
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    public void saveIngredient(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }

    public void removeIngredient(Ingredient ingredient){
        ingredientRepository.delete(ingredient);
    }

    public List<Ingredient> getIngredientForRecipe(Recipe recipe){
        return ingredientRepository.findIngredientsByRecipe(recipe);
    }

}
