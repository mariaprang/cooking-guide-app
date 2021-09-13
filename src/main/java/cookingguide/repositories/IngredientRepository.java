package cookingguide.repositories;

import cookingguide.models.Ingredient;
import cookingguide.models.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    public List<Ingredient> findIngredientsByRecipe(Recipe recipe);
    Ingredient findById(int id);

}
