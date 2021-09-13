package cookingguide.repositories;

import cookingguide.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    //add FindRecipeByName by name
}
