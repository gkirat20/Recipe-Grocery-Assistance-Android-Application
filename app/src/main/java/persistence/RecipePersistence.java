package persistence;

import java.util.List;

import objects.Recipe;

public interface RecipePersistence {

    List<Recipe> getRecipes();

    Recipe getRecipe(Recipe currentRecipe);

    Recipe insertRecipe(Recipe currentRecipe);

    Recipe updateRecipe(Recipe currentRecipe);

    void deleteRecipe(Recipe currentRecipe);
}
